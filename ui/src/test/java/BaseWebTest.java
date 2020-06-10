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

    private String verificationCode = "";

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

    /**
     * If this is the first time testing on a device, github will ask for a login verification code
     * sent to our gmail. In that case, we go to gmail and rip that code and put it in
     * @throws InterruptedException
     */
    private void setupExtension() throws InterruptedException {
        var linkToGithubPage = new LinkToGithubPage();
        var githubAuthPage = linkToGithubPage.beginLinkToGithub()
            .setUsername(Credentials.TEST_USERNAME_GITHUB)
            .setPassword(Credentials.TEST_PASSWORD_GITHUB)
            .clickLogin();
        Thread.sleep(3000);
        if (githubAuthPage.isOpened()) {
            loginGoogle();
            githubAuthPage.sendVerificationCode(verificationCode);
        }
        var handles = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(handles.get(0));
        var raptorNamingPage = new RaptorNamingPage();
        Thread.sleep(3000);
        var repositorySettingPage = raptorNamingPage.setRaptorName(testRaptorName)
            .submitName();
        extensionPage = repositorySettingPage.selectRepositoryByName(startingRepo)
            .submitRepositorySelection();
    }

    private void loginGoogle() throws InterruptedException {
        var handles = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(handles.get(0));
        getWebDriver().get("https://accounts.google.com");
        var googleLoginPage = new GooglePage();
        googleLoginPage.loginAsUser(Credentials.TEST_USERNAME_GMAIL, Credentials.TEST_PASSWORD_GMAIL);
        getWebDriver().get("https://gmail.com");
        verificationCode = googleLoginPage.getGithubVerificationCode();
        getWebDriver().switchTo().window(handles.get(1));
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

}
