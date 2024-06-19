import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        URL serverURL= new URL("http://localhost:4723/");

        driver= new AndroidDriver(serverURL, options);
    }

    @Test
    public void additionTest() {
        //Addition of numbers
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String finalResult = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println("Addition of numbers: " + finalResult);
        Assert.assertEquals(finalResult, "14");
    }
    @Test
    public void subtractTest() {
        //Subtraction of numbers
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String finalResult = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println("Subtraction of numbers: " + finalResult);
        Assert.assertEquals(finalResult, "5");
    }
    @Test
    public void multiplyTest() {
        //Multiplication of numbers
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String finalResult = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println("Multiplication of numbers: " + finalResult);
        Assert.assertEquals(finalResult, "500");
    }
    @Test
    public void divisionTest(){
        //Division of numbers
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String finalResult= driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println("Division of numbers: "+finalResult);
        Assert.assertEquals(finalResult, "25");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
