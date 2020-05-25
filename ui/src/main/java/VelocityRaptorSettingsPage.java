import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VelocityRaptorSettingsPage extends SettingsPage {

    private final SelenideElement velocityRaptorHeader = $x("//div[contains(text(),'My VelocityRaptor')]");

    private final SelenideElement accessoryTypeDropdown = $("select[class='options']");

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

    public VelocityRaptorSettingsPage selectAccessoryByName(String accessoryName){
        SelenideElement element = $(String.format("img[alt='%s']", accessoryName));
        SelenideElement elementTwo = $(String.format("img[alt='%s']", accessoryName)).parent();
        $(String.format("img[alt='%s']", accessoryName)).parent().click();
        return this;
    }

}
