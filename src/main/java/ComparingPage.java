import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ComparingPage {
    @Step
    public ComparingPage selectAllCharacteristics() {
        $x("//div[@class='_2bm8juabMn']/button[2]").click();
        return this;
    }

    @Step
    public ComparingPage selectDifferentCharacteristics() {
        $x("//div[@class='_2bm8juabMn']/button[1]").click();
        return this;
    }

    @Step
    public ComparingPage isThereTwoPhonesInList() {
        $$("._1qSSlc4Oxp").shouldHaveSize(2);
        return this;
    }

    @Step
    public ComparingPage OSIsDisplayed() {

        $x("//div[text()='Операционная система']").shouldBe(Condition.visible);
        return this;
//        return $$("_1P4gDT01yj div").findBy(text("Операционная система")).is(Condition.visible);
    }

    @Step
    public ComparingPage OSIsNotDisplayed() {

        $x("//div[text()='Операционная система']").shouldBe(Condition.hidden);
        return this;
//        return $$("_1P4gDT01yj div").findBy(text("Операционная система")).is(Condition.visible);
    }
}
