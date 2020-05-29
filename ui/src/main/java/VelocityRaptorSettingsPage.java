import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VelocityRaptorSettingsPage extends SettingsPage {

    private final SelenideElement velocityRaptorHeader = $x("//div[contains(text(),'My VelocityRaptor')]");

    public VelocityRaptorSettingsPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        velocityRaptorHeader.shouldBe(Condition.visible);
    }

    public VelocityRaptorSettingsPage setAccessoryType(String accessoryType){
        $(String.format("button[value='%s']", accessoryType)).click();
        return this;
    }

    public VelocityRaptorSettingsPage selectAccessoryByName(String accessoryName){
        if ($(String.format("img[alt='%s']", accessoryName),1).exists()){
            $(String.format("img[alt='%s']", accessoryName),1).parent().click();
        } else {
            $(String.format("img[alt='%s']", accessoryName)).parent().click();
        }
        return this;
    }

}
