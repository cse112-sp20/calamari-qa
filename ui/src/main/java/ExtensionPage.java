import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ExtensionPage extends BasePage {

    // TODO: Replace header with Velocity Raptor header
    private final SelenideElement extensionHeader = $x("//img[@class='logo']");

    private final SelenideElement raptorImage = $x("");

    private final SelenideElement raptorSpeedField = $x("");

    private final ElementsCollection tasksList = $$x("");

    public ExtensionPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        extensionHeader.shouldBe(Condition.visible);
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
        // TODO: Insert path for specific accessory containing accessoryName as attribute
        if (raptorImage.$x(String.format("", accessoryName)).exists()){
            return true;
        }
        return false;
    }

}
