package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * URL - https://test2.skdo.ru/#/
 * Страница авторизации
 */
public class AuthorizationPage extends BasePage {

    By loginInputLocator = By.id("add_user_login");
    By passwordInputLocator = By.id("add_user_password");// Текстовое поле для ввода пароля
    By entryButtonLocator = By.id("login_next");// кнопка Вход
    By confirmCodeInputLocator = By.id("confirmation_code");// Текстовое поле для ввода кода из присланного смс
    By continueButtonLocator = By.id("send_message_next");// Кнопка Продолжить

    public AuthorizationPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor javascriptExecutor) {
        super(driver,wait,javascriptExecutor);
    }

    /**
     * Переход на указанный URL
     */
    public void openAuthorizationPage(String URL){
        driver.get(URL);
    }

    /**
     * Метод для авторизации(логин,пароль,кнопка вход)
     * @param login
     * @param password
     */
    public void entry(String login,String password){
        inputText(loginInputLocator,login);
        inputText(passwordInputLocator,password);
        click(entryButtonLocator);
    }

    /**
     * Подтверждение кодом из присланного смс
     * @param smsCode
     */
    public void smsConfirmation(String smsCode){
        inputText(confirmCodeInputLocator,smsCode);
        click(continueButtonLocator);
    }
}
