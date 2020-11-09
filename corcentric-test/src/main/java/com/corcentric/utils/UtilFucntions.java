package com.corcentric.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.corcentric.driver.Config;
import com.corcentric.driver.DriverFactory;

public class UtilFucntions extends DriverFactory{

	public WebDriver driver;

    public UtilFucntions() {
        driver = getChromnedriver();
    }

    public void openUrl() {
    	driver.get(Config.url);
    }
    
    public boolean click(By locator) {
        WebElement element = ifElementvisible(locator, Config.wait_time);

        if (element == null) {
            return false;
        }
        
        element.click();
        return true;
    }

    public String getText(By locator) {

        WebElement element = ifElementvisible(locator, Config.wait_time);

        if (element == null) {
            return null;
        }

        return element.getText();
    }

    public WebElement ifElementvisible(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
}
