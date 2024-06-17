package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1SD {
    private WebDriver driver;

    @Given("User is on Google Home Page")
    public void launch_google(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @When("User types in Cheese and hits ENTER")
    public void user_type_cheese() {
        driver.findElement(By.name("q")).sendKeys("CHeese");
        driver.findElement(By.name("btnK")).click();
    }
    @Then("Show how many search results were shown")
    public void serach_result() {
        String Title = driver.getTitle();
        Assert.assertEquals("CHeese - Google Search",Title);
    }
    @And("Close the browser")
    public void teardown() {
        driver.quit();
    }
}
