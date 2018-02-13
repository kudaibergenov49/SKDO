package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;

    //Constructor
    BasePage(WebDriver driver, WebDriverWait wait,JavascriptExecutor javascriptExecutor){
        this.driver = driver;
        this.wait = wait;
        this.javascriptExecutor = javascriptExecutor;
    }

    /**
     * клик по элементу
     * @param elementLocator
     */
    void click(By elementLocator){
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).click();
    }

    /**
     * Ввод текста
     * @param elementLocator
     * @param text
     */
    void inputText(By elementLocator,String text){
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).sendKeys(text);
    }

    /**
     * Текст элемента
     * @param elementLocator
     * @return
     */
    String getText(By elementLocator){
        return wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).getText();
    }
}
