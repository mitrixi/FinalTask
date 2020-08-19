import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class ComparingPage {
    @Step
    public void isThereTwoPhonesInList() {
        LocatorsUtil.isThereTwoPhonesInList.shouldHaveSize(2);
    }

    @Step
    public void selectAllCharacteristics() {
        LocatorsUtil.selectAllCharacteristics.click();
    }

    @Step
    public void OSIsDisplayed() {
        LocatorsUtil.OSElement.shouldBe(Condition.visible);
    }

    @Step
    public void selectDifferentCharacteristics() {
        LocatorsUtil.selectDifferentCharacteristics.click();
    }

    @Step
    public void OSIsNotDisplayed() {
        LocatorsUtil.OSElement.shouldBe(Condition.hidden);
    }
}
