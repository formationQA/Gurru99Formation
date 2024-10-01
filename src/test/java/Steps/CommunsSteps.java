package Steps;

import Driver.Setup;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Soit;
import org.openqa.selenium.WebDriver;
import Utils.Utils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommunsSteps  {
    private Scenario scenario;
    private static WebDriver driver;

    private static Utils utils;

    @Before
    public void setUp() {
        // Initialisation du WebDriver pour Chrome
        driver = Setup.getDriver();
        utils = new Utils();
    }

    @io.cucumber.java.Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Et("je me connecte sur l'url (.*)$")
    public void ConnexionWeb(String url) {
        driver.get(url);
    }

    @Soit("je fais une capture d'ecran avec le nom {string}")
    public void je_fais_une_capture_d_ecran_avec_le_nom(String nomFichier) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/target/screenshots/" + nomFichier + "_" + timestamp + ".png";

        try {
            utils.takeScreenshot(filePath);

            utils.insertScreenshotToScenario(scenario, filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
