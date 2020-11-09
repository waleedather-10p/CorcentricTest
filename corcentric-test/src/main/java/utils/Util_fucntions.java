package utils;

import driver.Config;
import driver.Driver_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util_fucntions extends Driver_Factory{

	public WebDriver driver;

    public Util_fucntions() {
        driver = get_chromne_driver();
    }

    public void open_url() {
    	driver.get(Config.url);
    }
    
    public boolean click(By locator) {
        WebElement element = if_element_visible(locator, Config.wait_time);

        if (element == null) {
            return false;
        }
        
        element.click();
        return true;
    }

    public String getText(By locator) {

        WebElement element = if_element_visible(locator, Config.wait_time);

        if (element == null) {
            return null;
        }

        return element.getText();
    }

    public WebElement if_element_visible(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
}
