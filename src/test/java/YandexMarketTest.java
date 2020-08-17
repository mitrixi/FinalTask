import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YandexMarketTest {
    MainPage mainPage;
    MobilePhonesCatalog mobilePhonesCatalog;
    ComparingPage comparingPage;

    @BeforeSuite
    public void initializePages() {
        mainPage = new MainPage();
        mobilePhonesCatalog = new MobilePhonesCatalog();
        comparingPage = new ComparingPage();
    }

    @BeforeSuite
    public void configureTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void preparingTest() {
        mainPage.enterToMainPage();
        mainPage.openMobilePhonesCatalog();

        mobilePhonesCatalog.selectComparedPhones();
        mobilePhonesCatalog.sortPhonesByPrice();
    }

    @Test(dependsOnMethods = "preparingTest")
    public void checkXiaomiAddedToComparison() {
        mobilePhonesCatalog.selectComparing("Xiaomi");
        assertThat(mobilePhonesCatalog.isPhoneAddedToComparing(), equalTo(true));
    }

    @Test(dependsOnMethods = "checkXiaomiAddedToComparison")
    public void checkRealmeAddedToComparison() {
        mobilePhonesCatalog.selectComparing("realme");
        assertThat(mobilePhonesCatalog.isPhoneAddedToComparing(), equalTo(true));
    }

    @Test(dependsOnMethods = "checkRealmeAddedToComparison")
    public void isThereTwoItemsInList() {
        comparingPage = mobilePhonesCatalog.pushButtonComparing();
        assertThat(comparingPage.isThereTwoPhonesInList().size(), equalTo(2));
    }

    @Test(dependsOnMethods = "isThereTwoItemsInList")
    public void positionOperationSystemIsDisplayed() {
        comparingPage.selectAllCharacteristics();
        assertThat(comparingPage.OSIsDisplayed(), equalTo(true));
    }

    @Test(dependsOnMethods = "positionOperationSystemIsDisplayed")
    public void positionOperationSystemIsNotDisplayed() {
        comparingPage.selectDifferentCharacteristics();
        assertThat(comparingPage.OSIsDisplayed(), equalTo(false));
    }
}
