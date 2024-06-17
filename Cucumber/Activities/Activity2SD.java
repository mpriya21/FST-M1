//package stepDefinition;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.checkerframework.checker.units.qual.C;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Activity2SD {
//    private WebDriver driver;
//
//    @Given("User is on Login page")
//    public void login_page() {
//        driver = new ChromeDriver();
//        driver.get("https://v1.training-support.net/selenium/login-form");
//    }
//    @When("User enters username and password")
//    public void user_input() {
//        driver.findElement(By.id("username")).sendKeys("admin");
//        driver.findElement(By.id("password")).sendKeys("password");
//        driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
//
//    }
//    @Then("Read the page title and confirmation message")
//    public void test_title(){
//        String Title = driver.getTitle();
//        Assert.assertEquals("Login Form",Title);
//        String msg = driver.findElement(By.id("action-confirmation")).getText();
//        Assert.assertEquals("Welcome Back, admin",msg);
//        System.out.println(Title);
//        System.out.println(msg);
//    }
//    @And("Close the Browser")
//    public void close_browser(){
//        driver.quit();
//    }
//}
