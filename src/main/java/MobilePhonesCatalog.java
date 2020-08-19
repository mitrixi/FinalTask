import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class MobilePhonesCatalog {

    @Step
    public void selectComparedPhone(String brand) {
        LocatorsUtil.selectBrandPhone(brand).click();
    }

    @Step
    public void sortPhonesByPrice() {
        LocatorsUtil.sortPhonesByPrice.click();
    }

    @Step
    public void selectComparing(String brand) {
        LocatorsUtil.selectComparing(brand).scrollIntoView(false).hover().click();
    }

    @Step
    public void pushButtonComparing() {
        // в firefox не срабатывает кнопка "сравнение",
        // если она закрыта уведомлением или находится вне области видимости страницы
        if (LocatorsUtil.closePopup.isDisplayed())
            LocatorsUtil.closePopup.click();
        LocatorsUtil.pushButtonComparing.scrollIntoView(true).click();
    }

    @Step
    public void isPhoneAddedToComparing() {
        LocatorsUtil.isPhoneAddedToComparing.shouldBe(Condition.visible);
    }
}
