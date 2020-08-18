import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MobilePhonesCatalog {
    @Step
    public void selectComparedPhones() {
        $x("//span[text()='Xiaomi']").click();
        $x("//span[text()='realme']").click();
    }

    @Step
    public void sortPhonesByPrice() {
        $x("//button[text()='по цене']").click();
    }

    @Step
    public void selectComparing(String brand) {
        $x("//div[..//a[contains(@href, '" + brand + "')]]/div[contains(@aria-label, 'сравнению')]").hover().click();
    }

    @Step
    public void pushButtonComparing() {
        // в firefox не срабатывает кнопка "сравнение",
        // если она закрата уведомлением или находится вне области видимости страницы
//        SelenideElement elem =  $("._3rzhojG-YQ._3t3LXmsKsK._3z2S53fBdS._1rROdYTYlo._1t_-Z3RX29");
//        if (elem.isDisplayed())
//            elem.click();
        $$x("//span[text()='Сравнение']").first().scrollIntoView(true).click();
    }

    @Step
    public void isPhoneAddedToComparing() {
        $x("//div[contains(text(), 'добавлен к сравнению')]").shouldBe(Condition.visible);
    }

}
