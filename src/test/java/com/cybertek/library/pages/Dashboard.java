package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    public Dashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath ="//span[.='Dashboard']" )
    public WebElement dashboard;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement booksLink;

    @FindBy(id = "book_count")
    public WebElement booksCount;

    @FindBy(id = "user_count")
    public WebElement usersCount;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropdown;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersLink;
}
