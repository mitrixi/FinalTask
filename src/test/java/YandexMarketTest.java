import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMarketTest {
    MainPage mainPage;
    MobilePhonesCatalog mobilePhonesCatalog;
    ComparingPage comparingPage;
    String firstBrand = System.getProperty("fb") != null ? System.getProperty("fb") : "Xiaomi";
    String secondBrand = System.getProperty("sb") != null ? System.getProperty("sb") : "realme";

    @BeforeClass
    public void configureTest() {
        Configuration.remote = "http://10.254.0.131:4444/wd/hub/";
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeMethod
    public void initializePages() {
        mainPage = new MainPage();
        mobilePhonesCatalog = new MobilePhonesCatalog();
        comparingPage = new ComparingPage();
    }

    @Description("Check functionality YandexMarket site")
    @Test(testName = "YandexMarketText")
    public void yandexMarketTest() {
        mainPage.enterToMainPage();
        mainPage.openMobilePhonesCatalog();
        mainPage.selectElectronics();
        mainPage.selectMobilePhones();

        mobilePhonesCatalog.selectComparedPhone(firstBrand);
        mobilePhonesCatalog.selectComparedPhone(secondBrand);
        mobilePhonesCatalog.sortPhonesByPrice();
        mobilePhonesCatalog.selectComparing(firstBrand);
        mobilePhonesCatalog.isPhoneAddedToComparing();
        mobilePhonesCatalog.selectComparing(secondBrand);
        mobilePhonesCatalog.isPhoneAddedToComparing();
        mobilePhonesCatalog.pushButtonComparing();

        comparingPage.isThereTwoPhonesInList();
        comparingPage.selectAllCharacteristics();
        comparingPage.OSIsDisplayed();
        comparingPage.selectDifferentCharacteristics();
        comparingPage.OSIsNotDisplayed();
    }
}
