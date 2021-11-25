package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "avito")
public class AvitoPage extends WebPage {
    @Name("Категория")
    private SelenideElement categoryList = $x("//select[@id='category']");

    @Name("Поле поиска")
    private SelenideElement searchInput = $x("//input[@data-marker='search-form/suggest']");

    @Name("выбор региона")
    private SelenideElement regionList = $x("//div[@data-marker='search-form/region']");

    @Name("Владивосток")
    private SelenideElement regionChoose = $x("//input[@data-marker='popup-location/region/input']");

    @Name("показать результаты")
    private SelenideElement searchButton = $x("//button[@data-marker='popup-location/save-button']");

    @Name("только с фотографией")
    private SelenideElement withPhotoCheckBox = $x("//input[@data-marker='search-form/with-images']");

    @Name("Фильтр")
    private SelenideElement filterList = $x("//option[text()='По умолчанию']");

    @Name("Топ 3")
    private ElementsCollection foundElements = $$x("//div[@data-marker='item']");

    public SelenideElement findCategoryByValue(String text){
        return $x(String.format("//option[contains(text(),'%s')]", text));
    }

    public SelenideElement findFilterByText(String text) {
        return $x(String.format("//option[text()='%s']", text));
    }

    public SelenideElement getCategoryList() {
        return categoryList;
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public SelenideElement getRegionList() {
        return regionList;
    }

    public SelenideElement getRegionChoose() {
        return regionChoose;
    }

    public SelenideElement getSearchButton() {
        return searchButton;
    }

    public SelenideElement getWithPhotoCheckBox() {
        return withPhotoCheckBox;
    }

    public SelenideElement getFilterList() {
        return filterList;
    }

    public ElementsCollection getFoundElements() {
        return foundElements;
    }
}

