package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Dashboard;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_stepDefinition {
    LoginPage loginPage = new LoginPage();
    Dashboard dashboardPage = new Dashboard();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user login as Librarian")
    public void userLoginAsLibrarian() {
        BrowserUtils.sleep(1);
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("librarianUsername"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        loginPage.signInButton.click();

    }
    @When("user login as Student")
    public void userLoginAsStudent() {
        BrowserUtils.sleep(1);
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("studentUsername"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        loginPage.signInButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String actualTitle = dashboardPage.dashboard.getText();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @Then("user should see Book Management")
    public void userShouldSeeBookManagement() {
        String actualTitle = dashboardPage.booksLink.getText();
        String expectedTitle = "Books";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailInput));
        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int users) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.usersCount));
        int expectedCount = users;
        int actualCount = Integer.parseInt(dashboardPage.usersCount.getText());

        Assert.assertEquals(expectedCount,actualCount);

    }




}
