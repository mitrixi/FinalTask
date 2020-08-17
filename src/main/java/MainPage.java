import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step
    public static MainPage enterToMainPage() {
        open("https://market.yandex.ru/");
        return page(MainPage.class);
    }

    @Step
    public MobilePhonesCatalog openMobilePhonesCatalog() {
        $x("//span[text()='Каталог товаров']").click();
        $("._35SYuInI1T._3G-TuDjlyZ._2BRGNp7I5O").hover();
        $("#\\33 9889743 div:nth-child(1)>ul>li:nth-child(1) a._2qvOOvezty._2x2zBaVN-3._3kgUl_l6nB").click();
        return page(MobilePhonesCatalog.class);
    }

}
