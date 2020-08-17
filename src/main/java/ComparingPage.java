import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class ComparingPage {
    public void selectAllCharacteristics() {
        $x("//div[@class='_2bm8juabMn']/button[2]").click();
    }

    public void selectDifferentCharacteristics() {
        $x("//div[@class='_2bm8juabMn']/button[1]").click();
    }

    public List<SelenideElement> isThereTwoPhonesInList() {
        return $$("._1qSSlc4Oxp");
    }

    public boolean OSIsDisplayed() {
        return $x("//div[text()='Операционная система']").isDisplayed();
//        return $$("_1P4gDT01yj div").findBy(text("Операционная система")).is(Condition.visible);
    }
}
