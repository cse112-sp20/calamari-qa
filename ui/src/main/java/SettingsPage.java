import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class SettingsPage extends BasePage {

    private final SelenideElement generalSettingsLink = $x("//a[contains(text(),'General')]");

    private final SelenideElement velocityRaptorSettingsLink = $x("//a[contains(text(),'Customize')]");

    private final SelenideElement myTeamSettingsLink = $x("//a[contains(text(),'My Team')]");

    private final SelenideElement githubRepoSettingsLink = $x("//a[contains(text(),'Github Repo')]");

    private final SelenideElement backButton = $x("//i[@class='fa fa-arrow-left ']");

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
