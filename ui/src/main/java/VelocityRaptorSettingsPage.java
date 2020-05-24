import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VelocityRaptorSettingsPage extends SettingsPage {

    private final SelenideElement velocityRaptorHeader = $x("//div[contains(text(),'My VelocityRaptor')]");

    private final SelenideElement accessoryTypeDropdown = $x("");

    public VelocityRaptorSettingsPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        velocityRaptorHeader.shouldBe(Condition.visible);
    }

    public VelocityRaptorSettingsPage setAccessoryType(String accessoryType){
        accessoryTypeDropdown.click();
        $(String.format("option[value='%s']", accessoryType)).click();
        return this;
    }

}
