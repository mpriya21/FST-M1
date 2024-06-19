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

public class ChromeActivity1 {
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
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+ ".scrollTextIntoView(\"To-Do List\")"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("taskInput")));
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        boolean tasksAdded= driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']")).isDisplayed();
        Assert.assertTrue(tasksAdded);
        //delete each task
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear List']")).click();
        boolean tasksRemoved= driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']")).isDisplayed();
        Assert.assertFalse(tasksRemoved);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
