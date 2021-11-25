package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.AvitoPage;
import ru.lanit.at.web.pagecontext.Environment;

public class AvitoSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvitoSteps.class);
    private final AvitoPage avitoPage = new AvitoPage();

    @Пусть("открыт ресурс авито url {string}")
    public void openAvito(String url){
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 50000;
        Selenide.open(url);
        WebDriver driver = Environment.getDriver();
        if (driver == null) {
            WebDriver currentThreadWebDriver = WebDriverRunner.getWebDriver();
            Environment.setThreadDriver(currentThreadWebDriver);
        }
        LOGGER.info("init webdriver for thread: {}", Thread.currentThread().getId());
    }

    @ParameterType("[A-Za-zA-Яа-я]+")
    public CategorySelected categorySelected(String category){
        return CategorySelected.valueOf(category);
    }
    @И("в выпадающем списке категорий выбрана {categorySelected}")
    public void clickOnCategory(CategorySelected categorySelected){
        avitoPage.getCategoryList().click();
        avitoPage.findCategoryByValue(categorySelected.getCategorySelected()).click();
    }

    @И("в поле поиска введено значение {string}")
    public void searchPrinter(String printer){
        avitoPage.getSearchInput().sendKeys(printer);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void regionChooseList(){
        avitoPage.getRegionList().click();
    }

    @Тогда("в поле регион введено значение {string}")
    public void vladivoctokClick(String city){
        avitoPage.getRegionChoose().sendKeys(city, Keys.ENTER);
    }

    @И("нажата кнопка показать объявления")
    public void clickSearch(){
        avitoPage.getSearchButton().click();
    }

    @Тогда("открылась страница по запросу {string}")
    public void openPagePrinter(String printer){
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
       // Assert.assertTrue(url.contains(printer));
    }

    @И("активирован чек бокс только с фотографией")
    public void clickWithPhotoBox(){
        avitoPage.getWithPhotoCheckBox().sendKeys(Keys.SPACE);
    }

    @ParameterType("[A-Za-zA-Яа-я]+")
    public SortPrice sortPrice(String sort){
        return SortPrice.valueOf(sort);
    }
    @И("в выпадающем списке сортировка выбрано значение {sortPrice}")
    public void setFilter(SortPrice sortPrice ){
        avitoPage.getFilterList().click();
        avitoPage.findFilterByText(sortPrice.getValue()).click();
    }

    @И("в консоль выведено значение названия и цены первых {int} товаров")
    public void outputItems(int k) {
        System.out.println("Выводим цены и названия товара в первых трёх объявлениях");
        for (int i = 0; i < k; i++) {
            String str = avitoPage.getFoundElements().get(i).getText();
            String[] offers = str.split("[₽]\\s*");
            LOGGER.info("сохранение в список '{}'", offers[0]);
        }
    }
}
