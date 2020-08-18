import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step
    public void enterToMainPage() {
        open("https://market.yandex.ru/");
    }

    @Step
    public void openMobilePhonesCatalog() {
        $x("//span[text()='Каталог товаров']").click();
        $x("//img[@alt='Электроника']").hover();
        $x("//a[text()='Мобильные телефоны']").click();
    }

}
