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
        LocatorsUtil.electronics.hover();
        LocatorsUtil.mobilePhones.click();
    }

}
