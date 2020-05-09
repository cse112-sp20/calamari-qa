import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseWebTest {

    // TODO: Figure out how to download files for extensions, then get them in a resources folder

    // Path to all extensions we want in our test browser
    private String[] EXTENSION_PATHS = new String[] {"INSERT_VELOCITY_RAPTOR_PATH_HERE",
        "INSERT_CHROPATH_PATH_HERE"};

    @BeforeMethod()
    private void startBrowser(){
        ChromeOptions chromeOptions = getChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        setWebDriver(driver);
    }

    // Setting up extensions for the driver
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        List<File> extensionFiles = new ArrayList<File>();
        Arrays.stream(EXTENSION_PATHS).forEach(path -> extensionFiles.add(new File(path)));
        options.addExtensions(extensionFiles);
        return options;
    }

    @AfterMethod(alwaysRun = true)
    private void closeBrowser(){
        getWebDriver().quit();
    }

}
