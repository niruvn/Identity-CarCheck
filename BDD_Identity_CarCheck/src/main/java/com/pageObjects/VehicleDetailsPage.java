package com.pageObjects;

import com.coreLibriaries.Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import static java.lang.String.format;

// All the page related elements for Vehicle details and actions go here
public class VehicleDetailsPage extends Page {
    protected WebDriverWait wait;

    public VehicleDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //jsx-3496807389
    @FindBy(xpath = "//vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[1]/div[2]")
    WebElement regNumber;


    @FindBy(xpath = "//vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[1]/div[2]")
    WebElement make;

    @FindBy(xpath = "//vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[2]/div[2]")
    WebElement model;

    @FindBy(xpath = "//vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[4]/div[2]")
    WebElement colour;

    @FindBy(xpath = "//vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[3]/div[2]")
    WebElement year;

    @FindBy(xpath = "//*[@id=\"wbac-app-container\"]/div/div/vehicle-questions/div/section[1]/div/div[1]/div")
    WebElement yourDetails;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[12]/div/div/dl/div/dd[2]/a")
    WebElement modalTryAgain;


    public boolean isVehicleNotFound(){
        try {
            if (yourDetails.isDisplayed()){
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public boolean isVehicleFound(){
        try {
            if (yourDetails.isDisplayed()){
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public String getRegNumber(){
        if (regNumber.isDisplayed()) {
            return regNumber.getText();
        }
        return "";
    }

    public String getMake(){
        if (make.isDisplayed()) {
            return make.getText();
        }
        return "";
    }

    public String getModel(){
        if (model.isDisplayed()) {
            return model.getText();
        }
        return "";
    }

    public String getColour(){
        if (colour.isDisplayed()) {
            return colour.getText();
        }
        return "";
    }

    public String getYear(){
        if (year.isDisplayed()) {
            return year.getText();
        }
        return "";
    }

    public HashMap<String, String> getVehicleDetails(WebDriver driver, String regNumber)  {
        HashMap<String, String> innerMap = new HashMap<String, String>();
        waitForPageLoad(driver);

        if (isVehicleFound()) {
            if (getRegNumber().equals(regNumber)) {
                innerMap.put("make", getMake());
                innerMap.put("model", getModel());
                innerMap.put("year", getYear());
            } else  {
                System.out.println(format("Vehicle details NOT found on the website for %s", regNumber));
                innerMap.put("make", "NOT FOUND");
            }
        }
        System.out.println(format("Inner map: Vehicle details for Reg: %s found. Make: %s, Model: %s, Year: %s", regNumber, innerMap.get("make"), innerMap.get("model"), innerMap.get("year") ));
        return innerMap;

    }
}
