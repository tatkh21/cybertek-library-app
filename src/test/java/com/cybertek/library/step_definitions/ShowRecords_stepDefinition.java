package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Dashboard;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ShowRecords_stepDefinition {
    Dashboard dashboard = new Dashboard();
    Select select;
    @When("user clicks on Users link")
    public void userClicksOnUsersLink() {
        BrowserUtils.waitForVisibility(dashboard.usersLink, 10);
        dashboard.usersLink.click();
    }
    @Then("Show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        select = new Select(dashboard.showRecordsDropdown);
        String actualValue = select.getFirstSelectedOption().getText();
        String expectedValue = String.valueOf(int1);

        Assert.assertEquals(expectedValue,actualValue);


    }
    @Then("show records should have following options")
    public void show_records_should_have_following_options(List<String> options) {
        select= new Select(dashboard.showRecordsDropdown);
        List <WebElement> actualOptions = select.getOptions();
        List<String> actualOptionsText = new ArrayList<>();
        for (WebElement element :actualOptions) {
           actualOptionsText.add(element.getText());
        }
       Assert.assertEquals(options,actualOptionsText);




    }


}
