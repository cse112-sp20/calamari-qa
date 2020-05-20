import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.testng.Assert.assertTrue;

public class BaseWebTest {

    Path resourcesDirectory = Paths.get("src","main", "resources", "extensions");

    private static final String[] EXTENSIONS = new String[] {"velocity_raptor.crx"};

    protected ExtensionPage extensionPage;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        ChromeOptions chromeOptions = getChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        setWebDriver(driver);
        extensionPage = BasePage.openExtension();
    }

    // Setting up extensions for the driver
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        List<File> extensionFiles = new ArrayList<File>();
        Arrays.stream(EXTENSIONS).forEach(extension -> extensionFiles.add(new File(
            resourcesDirectory.toFile().getAbsolutePath() + "/" + extension)));
        options.addExtensions(extensionFiles);
        return options;
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

}
