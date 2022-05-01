package com.userlane.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.naming.Name;
import javax.xml.xpath.XPath;

public class CareerPage extends BasePage {

@FindBy(xpath = "//a[@href='https://jobs.lever.co/userlane/19b969e3-e406-486c-82e6-483f62fe597f']")
    public WebElement applicationBtn;

@FindBy(xpath = "//a[@class='cta-button']")
    public WebElement positionBtn;



}
