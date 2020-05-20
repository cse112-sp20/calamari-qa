import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class SettingsPage extends BasePage {

    private final SelenideElement generalSettingsLink = $x("//a[contains(text(),'General')]");

    private final SelenideElement velocityRaptorSettingsLink = $x("//a[contains(text(),'VelocityRaptor')]");

    private final SelenideElement myTeamSettingsLink = $x("//a[contains(text(),'My Team')]");

    private final SelenideElement githubRepoSettingsLink = $x("//a[contains(text(),'Github Repo')]");

    public GeneralSettingsPage openGeneralSettingsPage() {
        generalSettingsLink.click();
        return new GeneralSettingsPage();
    }

    public VelocityRaptorSettingsPage openVelocityRaptorSettingsPage() {
        velocityRaptorSettingsLink.click();
        return new VelocityRaptorSettingsPage();
    }

    public MyTeamSettingsPage openMyTeamSettingsPage() {
        myTeamSettingsLink.click();
        return new MyTeamSettingsPage();
    }

    public GithubRepoSettingsPage openGithubRepoSettings() {
        githubRepoSettingsLink.click();
        return new GithubRepoSettingsPage();
    }

}
