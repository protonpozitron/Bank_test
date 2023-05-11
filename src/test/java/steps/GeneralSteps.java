package steps;

import cucumber.api.java.bg.И;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralSteps {

    private final Auth_Steps auth_steps;

    public GeneralSteps(Auth_Steps auth_steps) {
        this.auth_steps = auth_steps;
    }

    @И("проверить, что красная подсветка поля {string} присутствует")
    public void redBacklightCheck(String input) {
   //     auth_steps.pageElement().inputField(input).executeScript()
         auth_steps.pageElement().inputRedError(input).isDisplayed();
    }

    @И("нажать кнопку {string}")
    public void pushBtton(String name) {
        auth_steps.pageElement().button(name).click();
    }
    @И("по полю ввода {string} произвести клик")
    public void clickOnField(String name) {
        auth_steps.pageElement().inputField(name).click();
    }
    @И("нажать кнопку c лого {string}")
    public void pushLogo(String name) {
        auth_steps.pageElement().logo().click();
    }
    @И("открыта страница {string}")
    public void nameCheck(String name) {
        auth_steps.pageElement().header(name).isDisplayed();
    }

    @И("присутствует текст {string}")
    public void textCheck(String name) {
        auth_steps.pageElement().text(name).isDisplayed();
    }

    @И("нажать на вкладку {string}")
    public void pshtab(String name) {
        auth_steps.pageElement().tab(name).click();
    }

    @И("нажать на ссылку {string}")
    public void pshlink(String name) {
        auth_steps.pageElement().link(name).click();
    }
    @И("очистить поле {string}")
    public void deleteValue(String login) {
        auth_steps.pageElement().logPassField(login).sendKeys(Keys.CONTROL + "a");
        auth_steps.pageElement().logPassField(login).sendKeys(Keys.DELETE);
    }

    @И("очистить поле ввода {string}")
    public void deleteValueOnForm(String login) {
        auth_steps.pageElement().inputField(login).sendKeys(Keys.CONTROL + "a");
        auth_steps.pageElement().inputField(login).sendKeys(Keys.DELETE);
    }
    @И("в переменную {string} внести значение из колонки в {string} строке")
    public void saveValue(String name, String column) {
        String v = auth_steps.pageElement().columnValue(column).getText();
        auth_steps.timeCache.put(name, v);
        System.out.println("Key " + auth_steps.timeCache.get(name));
    }

    @И("по {string} строке произвести клик")
    public void tableRowClick(String name) {
        auth_steps.pageElement().columnValue(name).click();
    }

    @И("проверить, что на странице присутствует текст из переменной {string}")
    public void waitingFor(String str) {
        //  WebElement s= pageElement().text(str);
        String hashText = auth_steps.timeCache.get(str);
        auth_steps.pageElement().text(hashText).isDisplayed();
        WebDriverWait wait = new WebDriverWait(auth_steps.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(auth_steps.pageElement().text(hashText)));

    }

    @И("проверить, что присутсвуют поля:")
    public void fieldsCheck(List<String> fields) {
        fields.forEach(x -> auth_steps.pageElement().label(x).isDisplayed());
    }
    @И("навести курсор на выпадающий список {string} и выбрать значение {string}")
    public void placeTheCursor(String elemntName, String valueName) {
        Actions action = new Actions(auth_steps.driver);
        action.moveToElement(auth_steps.pageElement().tab(elemntName));
        auth_steps.pageElement().tab(valueName).click();
    }
    @И("в поле ввода {string} ввести значение {string}")
    public void fieldsInput(String input, String value) {
        auth_steps.pageElement().inputField(input).sendKeys(value);
    }
}