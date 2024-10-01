package Utils;

import Driver.Setup;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {

    private WebDriver driver;

    public Utils() {
        this.driver = Setup.getDriver();
    }

    public void takeScreenshot(String pathname) throws IOException {
        File screenshotFile = new File(pathname);
        File parentDir = screenshotFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, screenshotFile);
    }

    public void insertScreenshotToScenario(Scenario scenario, String pathname) throws IOException {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", pathname);
    }
}