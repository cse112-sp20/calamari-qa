import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ExtensionPage extends BasePage {

    private final SelenideElement raptorSpeedField = $x("//div[contains(text(),'Raptor's Speed:']");

    private final SelenideElement settingsIcon = $x("");

    public ExtensionPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        raptorSpeedField.shouldBe(Condition.visible);
    }

    public SettingsPage openSettingsPage(){
        settingsIcon.click();
        return new GeneralSettingsPage();
    }

}
