package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3SD {
    WebDriver driver;
    Alert alert;

    @Given("User is on the page")
    public void user_on_page(){
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }
    @When("User clicks the Simple Alert button")
    public void simple_alert_click(){
        driver.findElement(By.id("simple")).click();
    }
    @When("User clicks the Confirm Alert button")
    public void confirm_alert_click(){
        driver.findElement(By.id("confirm")).click();
    }
    @When("User clicks the Prompt Alert button")
    public void prompt_alert_click(){
        driver.findElement(By.id("prompt")).click();
    }
    @Then("Alert opens")
    public void switch_to_alert(){
        alert = driver.switchTo().alert();
    }
    @And("Read the text from it and print it")
    public void read_text(){
        System.out.println(alert.getText());
    }
    @And("Write a custom message in it")
    public void promptmessage(){
        alert.sendKeys("This is prompt message");
    }
    @And("Close the alert")
    public void close_alert(){
        alert.accept();
    }
    @And("Close the alert with Cancel")
    public void cancel_alert(){
        alert.dismiss();
    }
    @And("Close Browser")
    public void closebrowser(){
        driver.quit();
    }
}
