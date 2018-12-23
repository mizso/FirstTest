package environment;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class EnvironmentManager {

    public static void initDriver() {
        WebDriver driver;

        String browser = System.getProperty("BROWSER");
        if(browser==null){
            browser = System.getenv("BROWSER");
            if(browser==null){
                browser= "chrome";
            }
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.setLogLevel(Level.OFF);
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
                driver = new FirefoxDriver(options);
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        System.out.println("Opening Browser: " + browser);
        RunEnvironment.setDriver(driver);
        driver.manage().deleteAllCookies();
    }

    public static void shutDownDriver(){
        RunEnvironment.getDriver().quit();
    }
}
