package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Factory {
	private static WebDriver driver;

    public WebDriver get_chromne_driver() {
    	System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void close_driver() {
        driver.quit();
    }
}
