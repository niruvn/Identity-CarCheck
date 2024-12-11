package com.coreLibriaries;

import com.coreLibriaries.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.apache.commons.lang3.StringUtils.EMPTY;


// All page objects should extend this class and methods can be overwritten in the child class

public abstract class Page {
    protected WebDriver driver;
    protected WebElement element;
    protected WebDriverWait wait;

    protected PageSetup page;

    public Page(WebDriver driver) {
        this.driver = driver;
        page = new PageSetup(driver);
    }

    public boolean isDisplayed() {
        return true;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getRelativeUrl() {
        return EMPTY;
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public By getAccessType(String type, String access_name) {
        switch (type) {
            case "id":
                return By.id(access_name);
            case "name":
                return By.name(access_name);
            case "class":
                return By.className(access_name);
            case "xpath":
                return By.xpath(access_name);
            case "css":
                return By.cssSelector(access_name);
            case "linkText":
                return By.linkText(access_name);
            case "partialLinkText":
                return By.partialLinkText(access_name);
            case "tagName":
                return By.tagName(access_name);
            default:
                return null;

        }
    }
    // Wait for the page to load (30 sec) this value to be brought from config (TODO)
    public static void waitForPageLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until the document.readyState is "complete"
        for (int i = 0; i < 10; i++) { // Timeout after ~30 seconds
            try {
                Thread.sleep(3000);
                String readyState = js.executeScript("return document.readyState").toString();
                if (readyState.equals("complete")) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public boolean isElementDisplayed(String accessType,String accessName)
//    {
//        element = wait.until(ExpectedConditions.presenceOfElementLocated(getAccessType(accessType, accessName)));
//        return element.isDisplayed();
//    }
//    public boolean isElementPresent(String accessType,String accessName)
//    {
//        try {
//            if (!isElementDisplayed(accessType, accessName)){
//                return false;
//        } else {
//                return true;
//            }
//        } catch(Exception e)
//        {
//            return false;
//        }
//    }


}
