import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// This is the base page for settings, extend from it for settings tabs
public abstract class SettingsPage extends BasePage {

    private final SelenideElement generalSettingsLink = $x("");

    private final SelenideElement velocityRaptorSettingsLink = $x("");

    private final SelenideElement myTeamSettingsLink = $x("");

    private final SelenideElement helpSettingsLink = $x("");

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

    public HelpPage openHelpPage() {
        helpSettingsLink.click();
        return new HelpPage();
    }

}
