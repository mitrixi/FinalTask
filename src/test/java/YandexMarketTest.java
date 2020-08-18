import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMarketTest {
    MainPage mainPage;
    MobilePhonesCatalog mobilePhonesCatalog;
    ComparingPage comparingPage;

    @BeforeClass
    public void configureTest() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
    }

    @BeforeMethod
    public void initializePages() {
        mainPage = new MainPage();
        mobilePhonesCatalog = new MobilePhonesCatalog();
        comparingPage = new ComparingPage();
    }

//    @Description("Check functionality YandexMarket site")
//    @Test(testName = "YandexMarketText")
//    public void yandexMarketTest() {
//        new MainPage.enterToMainPage()
//                .openMobilePhonesCatalog()
//                .selectComparedPhones()
//                .sortPhonesByPrice()
//                .selectComparing("xiaomi")
//                .isPhoneAddedToComparing()
//                .selectComparing("realme")
//                .isPhoneAddedToComparing()
//                .pushButtonComparing()
//                .isThereTwoPhonesInList()
//                .selectAllCharacteristics()
//                .OSIsDisplayed()
//                .selectDifferentCharacteristics()
//                .OSIsNotDisplayed();
//    }

    @Description("Check functionality YandexMarket site")
    @Test(testName = "YandexMarketText")
    public void yandexMarketTest() {
        mainPage.enterToMainPage();
        mainPage.openMobilePhonesCatalog();

        mobilePhonesCatalog.selectComparedPhones();
        mobilePhonesCatalog.sortPhonesByPrice();
        mobilePhonesCatalog.selectComparing("xiaomi");
        mobilePhonesCatalog.isPhoneAddedToComparing();
        mobilePhonesCatalog.selectComparing("realme");
        mobilePhonesCatalog.isPhoneAddedToComparing();
        mobilePhonesCatalog.pushButtonComparing();

        comparingPage.isThereTwoPhonesInList();
        comparingPage.selectAllCharacteristics();
        comparingPage.OSIsDisplayed();
        comparingPage.selectDifferentCharacteristics();
        comparingPage.OSIsNotDisplayed();
    }
}
