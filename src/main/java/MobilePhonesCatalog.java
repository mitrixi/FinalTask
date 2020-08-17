import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MobilePhonesCatalog {
    @Step
    public MobilePhonesCatalog selectComparedPhones() {
        $("[for='7893318_7701962']").click();
        $("[for='7893318_16713696']").click();
        return this;
    }
    @Step
    public MobilePhonesCatalog sortPhonesByPrice() {
        $("._2zH77vazcW._3tIaiy1WMf").click();
        return this;
    }
    @Step
    public MobilePhonesCatalog selectComparing(String brand) {
//        $x("//div[@class='_2Qo3ODl0by cia-vs']//article//div[text()='" + brand + "']//..//preceding-sibling::a//preceding-sibling::div//div[@class='_2IwbFpEZn7 _3YfPcv73Wj _1rDffWmsUY']").hover().click();
        $x("//div[..//a[contains(@href, '" + brand + "')]]/div[contains(@aria-label, 'сравнению')]").hover().click();
        return this;
    }
    @Step
    public ComparingPage pushButtonComparing() {
        SelenideElement elem =  $("._3rzhojG-YQ._3t3LXmsKsK._3z2S53fBdS._1rROdYTYlo._1t_-Z3RX29");
        if (elem.isDisplayed())
            elem.click();
        $("._24DZ8VtEeO._3Vm6nmYXxJ").scrollIntoView(true).click();
        return page(ComparingPage.class);
    }
    @Step
    public MobilePhonesCatalog isPhoneAddedToComparing() {
        $("._1_ABPFjOJQ").shouldBe(Condition.visible);
        return this;
    }

}
