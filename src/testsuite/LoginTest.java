package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //send data to the username field
        sendTextToElement(By.xpath("//input[@name = 'username']"), "tomsmith");
        //send data to the password field
        sendTextToElement(By.xpath("//input[@name = 'password']"), "SuperSecretPassword!");
        //click on the login button
        clickOnElement(By.xpath("//button[@class = 'radius']/i[@class =  'fa fa-2x fa-sign-in' ]"));

        //declaring the variable for expected text  from requirements
        String expectedText = "Secure Area";
        //getting the actual text from the element
        String actualText = getTextFromElement(By.xpath("//div[@class = 'example']/h2"));
        //verifying that the user is able to log in
        Assert.assertEquals("Not logged in", expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        //send data to the username field
        sendTextToElement(By.xpath("//input[@name = 'username']"), "tomsmith1");
        //send data to the password field
        sendTextToElement(By.xpath("//input[@name = 'password']"), "SuperSecretPassword!");
        //click on the login button
        clickOnElement(By.xpath("//button[@class = 'radius']/i[@class =  'fa fa-2x fa-sign-in' ]"));


        //declaring the variable for expected text  from requirements
        String expectedText = "Your username is invalid!\n"+ "×";
        //getting the actual text from the element
        String actualText = getTextFromElement(By.xpath("//div[@id = 'flash']"));
        //verifying the username error message
        Assert.assertEquals("Username error message is not displayed", expectedText, actualText);
    }


    @Test
    public void verifyThePasswordErrorMessage(){

        //send data to the username field
        sendTextToElement(By.xpath("//input[@name = 'username']"), "tomsmith");
        //send data to the password field
        sendTextToElement(By.xpath("//input[@name = 'password']"), "SuperSecretPassword");
        //click on the login button
        clickOnElement(By.xpath("//button[@class = 'radius']/i[@class =  'fa fa-2x fa-sign-in' ]"));

        //declaring the variable for expected text  from requirements
        String expectedText = "Your password is invalid!\n"+ "×";
        //getting the actual text from the element
        String actualText = getTextFromElement(By.xpath("//div[@id = 'flash']"));
        //verifying the password error message
        Assert.assertEquals("Password error message is not displayed", expectedText, actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
