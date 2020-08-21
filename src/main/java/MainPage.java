import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step
    public void enterToMainPage() {
        open("https://market.yandex.ru/");
    }

    @Step
    public void openMobilePhonesCatalog() {
        LocatorsUtil.productCatalog.click();
    }

    @Step
    public void selectElectronics() {
        LocatorsUtil.electronics.hover();
    }

    @Step
    public void selectMobilePhones() {
        LocatorsUtil.mobilePhones.click();
    }

}
