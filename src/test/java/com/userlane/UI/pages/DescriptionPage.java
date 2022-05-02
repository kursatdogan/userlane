package com.userlane.UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class DescriptionPage extends BasePage{

    @FindBy (xpath = "//a[@class='postings-btn template-btn-submit hex-color']")
    public WebElement appyPositionBtn;

}
