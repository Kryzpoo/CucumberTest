package siriustest.steps;

import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.manage.TestManager;

public class CheckDisplaySteps {

    private static final String translatedSymbols = "translate(normalize-space(), ' \u00A0\u200B\u00AD', '')";
    private WebDriverWait wait = TestManager.getWait();
    private WebDriverWait shortWait = TestManager.getShortWait();

    @Тогда("^элемент \"([^\"]*)\" с текстом \"([^\"]*)\" должен быть отображен$")
    public void elementShouldBeDisplayed(String elementType, String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(@class, '" + elementType + "_text') and " + translatedSymbols + " = '" + elementText + "' ]" )));
    }

    @Тогда("^элемент 'notes' с текстом \"([^\"]*)\" должен быть отображен$")
    public void elementNotesShouldBeDisplayed(String notesText) throws Throwable {
        notesText = notesText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'description_text']/..//*[contains(" + translatedSymbols + ", '" + notesText + "')]" )));
    }

    @Тогда("^элемент 'поле региона' с текстом \"([^\"]*)\" должен быть отображен$")
    public void elementRegionFieldShouldBeDisplayed(String regionText) throws Throwable {
        regionText = regionText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption']/..//*[" + translatedSymbols + " = '" + regionText + "']" )));
    }

    @Тогда("^элемент 'support' с текстом \"([^\"]*)\" должен быть отображен$")
    public void elementSupportShouldBeDisplayed(String supportText) throws Throwable {
        supportText = supportText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'timeout_support']/..//*[" + translatedSymbols + " = '" + supportText + "']" )));
    }

    @Тогда("^элемент 'экран ожидания' должен быть отображен$")
    public void elementTimeoutScreenShouldBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'timeout_message']" )));
    }

    @Тогда("^шаблон \"([^\"]*)\" должен быть отображен$")
    public void templateShouldBeAn(String templateName) throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//meta[@content = '" + templateName + ".html']" )));
    }

    @Тогда("^элемент с текстом \"([^\"]*)\" должен быть отображен$")
    public void elementShouldBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + elementText + "']")));
    }

    @Тогда("^клавиатура должна быть отображена$")
    public void userShouldSeeKeyboard() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@class = 'b-numpad' or @class = 'kb_all']")));
    }

    @Тогда("^чек должен быть отображен$")
    public void checkShouldBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "b-receipt" )));
    }

    @Тогда("^на чеке должна быть отображена строка \"([^\"]*)\"$")
    public void checkShouldContainString(String checkText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(text(), '" + checkText + "')]" )));
    }

    @Тогда("^элемент \"([^\"]*)\" с текстом \"([^\"]*)\" должен быть отображен на странице 'ОК'$")
    public void elementShouldBeDisplayedOnOKPage(String elementType, String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'report_" + elementType + "']/..//*[" + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Тогда("^элемент \"([^\"]*)\" с текстом \"([^\"]*)\" должен быть отображен на странице 'Ошибка'$")
    public void elementShouldBeDisplayedOnErrorPage(String elementType, String elementText) throws Throwable {
        elementShouldBeDisplayedOnOKPage(elementType, elementText);
    }

    @Тогда("^элемент \"([^\"]*)\" с текстом \"([^\"]*)\" должен быть отображен на странице 'Итого'$")
    public void elementShouldBeDisplayedOnTotalPage(String elementCaption, String elementText) throws Throwable {
        elementCaption = elementCaption.replaceAll(" ", "");
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[" + translatedSymbols + " = '" + elementCaption + "']/../..//*[" + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Тогда("^приветствие \"([^\"]*)\" должно быть отображено$")
    public void greetingShouldBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption' and " + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Тогда("^элемент с текстом \"([^\"]*)\" не должен быть отображен$")
    public void elementWithTextShouldNotBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        shortWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("//*[" + translatedSymbols + " = '" + elementText + "']"))));
    }

    @Тогда("^элемент прокрутки страницы должен быть отображен$")
    public void scrollbarShouldBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(@class, 'b-scroll-bar') and not(contains(@style, 'display::none'))][not(ancestor::div[contains(@style,'display:none')])]" )));
    }

    @Тогда("^элемент 'помощь' с текстом \"([^\"]*)\" должен быть отображен$")
    public void elementHelp_notesShouldBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + elementText + "']")));
    }
}