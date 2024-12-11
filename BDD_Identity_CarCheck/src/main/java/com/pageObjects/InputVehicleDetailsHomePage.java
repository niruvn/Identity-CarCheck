package com.pageObjects;

import com.coreLibriaries.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// All the page related elements and actions go here

public class InputVehicleDetailsHomePage extends Page {

    public InputVehicleDetailsHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookies;

    @FindBy(xpath = "//*[@id=\"wbac-app-container\"]/div/div/vehicle-registration-check/section[1]/div/div[1]/div/div[1]/h1")
    WebElement carNotFound;


    @FindBy(id = "vehicleReg")
    WebElement regInput;

    @FindBy(id = "Mileage")
    WebElement regMileage;


    @FindBy(xpath = "//*[@id=\"mvtb-lookup-form\"]/div[2]/div/div[2]/button")
    WebElement getValuation;

    public boolean isPageDisplayed() {
        return driver.getTitle().equals("Sell your car in under an hour | Buy my car | webuyanycar");
    }

    public void enterRegNumber(String regNumber){


        regMileage.sendKeys("10000");
        regInput.sendKeys(regNumber);
        regMileage.sendKeys(Keys.ENTER);
    }

    public void enterMileage(String mileage){
        regMileage.sendKeys(mileage);
    }

    public void getMyCarValue(){
        WebElement valuationButton = driver.findElement(By.cssSelector("button[data-qa='valuation-submit-button']"));
        valuationButton.click();
    }

    public void acceptCookies(){
        acceptCookies.click();
    }

    public boolean isVehicleFound(){
        try {
            if (carNotFound.isDisplayed()){
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }


}
