import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

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

    protected String testRaptorName = "Test Raptor";

    protected String startingRepo = Repositoriies.TEST_REPOSITORY_ONE;

    protected ExtensionPage extensionPage;

    @BeforeClass(alwaysRun = true)
    public void startBrowserInitExtension() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = getChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        setWebDriver(driver);
        BasePage.openExtension();
        setupExtension();
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

    // We get verifications here due to page constructors
    private void setupExtension() throws InterruptedException {
        var linkToGithubPage = new LinkToGithubPage();
        var githubAuthenticationPage = linkToGithubPage.beginLinkToGithub()
            .setUsername(GithubCredentials.TEST_USERNAME)
            .setPassword(GithubCredentials.TEST_PASSWORD)
            .clickLogin();
        if (githubAuthenticationPage.isOpened()){
            // put in recovery code
        }
        var raptorNamingPage = new RaptorNamingPage();
        Thread.sleep(3000);
        var repositorySettingPage = raptorNamingPage.setRaptorName(testRaptorName)
            .submitName();
        extensionPage = repositorySettingPage.selectRepositoryByName(startingRepo)
            .submitRepositorySelection();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

}
