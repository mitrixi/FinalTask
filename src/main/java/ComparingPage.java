import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ComparingPage {
    @Step
    public void isThereTwoPhonesInList() {
        $$("._1qSSlc4Oxp").shouldHaveSize(2);
    }

    @Step
    public void selectAllCharacteristics() {
        $x("//button[text()='Все характеристики']").click();
    }

    @Step
    public void OSIsDisplayed() {
        $x("//div[text()='Операционная система']").shouldBe(Condition.visible);
    }

    @Step
    public void selectDifferentCharacteristics() {
        $x("//button[text()='Различающиеся характеристики']").click();
    }

    @Step
    public void OSIsNotDisplayed() {
        $x("//div[text()='Операционная система']").shouldBe(Condition.hidden);
    }
}
