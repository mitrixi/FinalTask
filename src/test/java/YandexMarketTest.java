import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Description("Check functionality YandexMarket site")
    @Test(testName = "YandexMarketText")
    public void yandexMarketTest() {
        MainPage.enterToMainPage()
                .openMobilePhonesCatalog()
                .selectComparedPhones()
                .sortPhonesByPrice()
                .selectComparing("xiaomi")
                .isPhoneAddedToComparing()
                .selectComparing("realme")
                .isPhoneAddedToComparing()
                .pushButtonComparing()
                .isThereTwoPhonesInList()
                .selectAllCharacteristics()
                .OSIsDisplayed()
                .selectDifferentCharacteristics()
                .OSIsNotDisplayed();
    }
}
