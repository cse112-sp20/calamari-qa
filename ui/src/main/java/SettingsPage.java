import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class SettingsPage extends BasePage {

    private final SelenideElement generalSettingsLink = $x("//a[contains(text(),'General')]");

    private final SelenideElement velocityRaptorSettingsLink = $x("//a[contains(text(),'My VelocityRaptor')]");

    private final SelenideElement githubRepoSettingsLink = $x("//a[contains(text(),'Github Repo')]");

    private final SelenideElement backButton = $("img[alt='go back']");

    public GeneralSettingsPage openGeneralSettingsPage() {
        generalSettingsLink.click();
        return new GeneralSettingsPage();
    }

    public VelocityRaptorSettingsPage openVelocityRaptorSettingsPage() {
        velocityRaptorSettingsLink.click();
        return new VelocityRaptorSettingsPage();
    }

    public GithubRepoSettingsPage openGithubRepoSettings() {
        githubRepoSettingsLink.click();
        return new GithubRepoSettingsPage();
    }

    public ExtensionPage backToExtensionPage(){
        backButton.click();
        return new ExtensionPage();
    }

}
