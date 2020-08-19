import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LocatorsUtil {

    public static SelenideElement productCatalog = $x("//span[text()='Каталог товаров']");
    public static SelenideElement electronics = $x("//img[@alt='Электроника']");
    public static SelenideElement mobilePhones = $x("//a[text()='Мобильные телефоны']");

    public static SelenideElement sortPhonesByPrice = $x("//button[text()='по цене']");
    public static SelenideElement closePopup = $x("//div[@data-apiary-widget-name='@market/PopupInformer']//button");
    public static SelenideElement pushButtonComparing = $$x("//span[text()='Сравнение']").first();
    public static SelenideElement isPhoneAddedToComparing = $x("//div[contains(text(), 'добавлен к сравнению')]");

    public static ElementsCollection isThereTwoPhonesInList = $$x("//a[contains(text(), 'Смартфон')]");
    public static SelenideElement selectAllCharacteristics = $x("//button[text()='Все характеристики']");
    public static SelenideElement OSElement = $x("//div[text()='Операционная система']");
    public static SelenideElement selectDifferentCharacteristics = $x("//button[text()='Различающиеся характеристики']");

    public static SelenideElement selectBrandPhone(String brand) {
        return $x(String.format("//span[text()='%s']", brand));
    }

    public static SelenideElement selectComparing(String brand) {
        return $x(String.format("//div[..//a[contains(@href, '%s')]]/div[contains(@aria-label, 'сравнению')]", brand.toLowerCase()));
    }
}
