package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeActivity3 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("org.chromium.chrome.browser.ChromeTabbedActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/");
        driver= new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void chromeTest(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(UiScrollable+ ".scrollTextIntoView(\"To-Do List\")")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+ ".scrollTextIntoView(\"Popups\")"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Popups']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")).click();

        //Login failure
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Sign In']")));
        driver.findElement(AppiumBy.id("username")).sendKeys("admin");
        driver.findElement(AppiumBy.id("password")).sendKeys("passw0rd");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("action-confirmation")));
        String loginConfirmation= driver.findElement(AppiumBy.id("action-confirmation")).getText();
        Assert.assertEquals(loginConfirmation, "Invalid Credentials");

        //Login success
        driver.findElement(AppiumBy.id("username")).sendKeys("admin");
        driver.findElement(AppiumBy.id("password")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("action-confirmation")));
        loginConfirmation= driver.findElement(AppiumBy.id("action-confirmation")).getText();
        Assert.assertEquals(loginConfirmation, "Welcome Back, admin");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
