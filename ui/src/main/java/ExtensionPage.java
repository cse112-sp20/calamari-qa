import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ExtensionPage extends BasePage {

    private final SelenideElement raptorSpeedField = $x("//div[contains(text(),'Speed:')]");

    private final SelenideElement settingsIcon = $("a[href='/root/html/user_settings.html']");

    private final SelenideElement raptorImage = $x("");

    private final ElementsCollection tasksList = $$x("");

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

    public ExtensionPage markTaskAtIndexComplete(int index){
        SelenideElement task = getTaskAtIndex(index);
        // TODO: Fill in xpath for checkbox element within task here
        SelenideElement taskCheckbox = task.$x("");
        taskCheckbox.click();
        return this;
    }

    public boolean isRaptorRunningAtSpeed(int expectedSpeed){
        int currentRaptorSpeed = Integer.parseInt(raptorSpeedField.getValue().substring(14,16));
        return expectedSpeed == currentRaptorSpeed;
    }

    public SelenideElement getTaskAtIndex(int index){
        return tasksList.get(index);
    }

    public boolean isRaptorWearingAccessory(String accessoryName){
        if ($(String.format("img[alt='%s']", accessoryName)).isDisplayed()){
            return true;
        }
        return false;
    }

}
