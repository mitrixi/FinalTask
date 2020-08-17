import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class MobilePhonesCatalog {
    public void selectComparedPhones() {
        $("[for='7893318_7701962']").click();
        $("[for='7893318_16713696']").click();
    }

    public void sortPhonesByPrice() {
        $("._2zH77vazcW._3tIaiy1WMf").click();
    }

    public void selectComparing(String brand) {
        $x("//div[@class='_2Qo3ODl0by cia-vs']//article//div[text()='" + brand + "']//..//preceding-sibling::a//preceding-sibling::div//div[@class='_2IwbFpEZn7 _3YfPcv73Wj _1rDffWmsUY']").hover().click();
    }

    public ComparingPage pushButtonComparing() {
        $("._24DZ8VtEeO._3Vm6nmYXxJ").hover().click();
        return page(ComparingPage.class);
    }

    public boolean isPhoneAddedToComparing() {
        return $("._1_ABPFjOJQ").waitUntil(Condition.visible, 10000).isEnabled();
    }

}
