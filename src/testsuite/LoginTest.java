package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Utility;

import java.time.Duration;

public class LoginTest extends Utility {

    String baseurl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseurl);

    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        //* click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));

        //* Verify the text ‘Welcome Back!’
        String actualText = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        String expectedText = "Welcome Back!";
        Assert.assertEquals(expectedText,actualText);


    }
    @Test
    public void verifyTheErrorMessage()
    {
        //* click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));

        //* Enter invalid username
        sendTextToElement(By.xpath("//input[@id='user[email]']"),"dfg@gmail.com");

        //* Enter invalid password
        sendTextToElement(By.xpath("//input[@id='user[password]']"),"dfg123456");
        //* Click on Login button
        clickOnElement(By.xpath("//input[@type='submit']"));

        //* Verify the error message ‘Invalid email or password.
        String actualText = getTextFromElement(By.xpath("//div[@class='notice__form-error']"));
        String expectedText = "Invalid email or password.";
        Assert.assertEquals(expectedText,actualText);

    }

    @After
    public void close()
    {
        closeBrowser();
    }
}

