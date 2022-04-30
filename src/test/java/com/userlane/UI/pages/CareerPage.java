package com.userlane.UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class CareerPage extends BasePage {

@FindBy(xpath = "//*[contains(text(),'Automation Test Engineer')]")
    public WebElement applicationBtn;


}
