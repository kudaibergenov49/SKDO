package tests;

import org.testng.Assert;
import pages.AuthorizationPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PersonalProfileSROPage;

/**
 * @author Kudaibergen Kuanysh
 *
 * Тестовое задание СКДО
 */
public class SKDOTest extends BaseTest {
    private Pages pages = new Pages();

    private class Pages{
        AuthorizationPage authorizationPage = new AuthorizationPage(driver,wait,javascriptExecutor);
        PersonalProfileSROPage personalProfileSROPage = new PersonalProfileSROPage(driver,wait,javascriptExecutor);
    }

    @Test
    private void initializePages(){
        pages = new Pages();
    }

    @Test(dataProvider = "testData",dependsOnMethods = "initializePages")
    public void authorization(String URL,String login,String password,String smsCode,String titleText) throws InterruptedException {

        pages.authorizationPage.openAuthorizationPage(URL);//Переход на сайт компании
        pages.authorizationPage.entry(login,password);// Ввод логина и пароля, кнопка продолжить
        pages.authorizationPage.smsConfirmation(smsCode);// Ввод подтверждения смс кода
        String title = pages.personalProfileSROPage.getTitleText();//
        Assert.assertEquals(title, titleText);// Проверка прохода авторизованности
    }

    @DataProvider
    private Object[][] testData(){
        return new Object[][]{
                {"https://test2.skdo.ru/","1087799035840","Barsik22","9","Личный кабинет СРО"}
        };
    }
}