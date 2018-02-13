package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Личный кабинет СРО
 */
public class PersonalProfileSROPage extends BasePage {
    private final By title = By.className("topbar-title");// Title

    /**
     * Конструктор
     * @param driver
     * @param wait
     * @param javascriptExecutor
     */
    public PersonalProfileSROPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor javascriptExecutor) {
        super(driver, wait,javascriptExecutor);
    }

    /**
     * @return Текст оглавления(Title text)
     */
    public String getTitleText(){
        return getText(title);
    }
}
