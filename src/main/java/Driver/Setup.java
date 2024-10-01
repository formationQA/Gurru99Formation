package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Setup {

    private static WebDriver driver;
    protected static Logger LOGGER = LogManager.getLogger();


    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            LOGGER.info("CONNEXION chrome.");
        }
        return driver;
    }


    public static void FermerDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            LOGGER.info("Ferme la page");
        }
    }
}