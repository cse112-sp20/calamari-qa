import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ExtensionPage extends BasePage {

    private final SelenideElement extensionPageHeader = $("div[class='card-header']");

    private final SelenideElement raptorSpeedField = $x("//div[contains(text(),'Speed:')]");

    private final SelenideElement settingsIcon = $("a[href='/root/html/user_settings.html']");

    private final ElementsCollection issueList = $("ul[id='githubIssuesList']").$$("li");

    public ExtensionPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        extensionPageHeader.shouldBe(Condition.visible);
    }

    public GeneralSettingsPage openSettingsPage() {
        settingsIcon.click();
        return new GeneralSettingsPage();
    }

    public ExtensionPage closeIssueAtIndex(int index) {
        SelenideElement issue = getIssueAtIndex(index);
        // TODO: Fill in xpath for checkbox element within task here
        issue.$("input[type='checkbox']").click();
        return this;
    }

    public boolean isRaptorRunningAtSpeed(int expectedSpeed) {
        int currentRaptorSpeed = getCurrentVelocity();
        return expectedSpeed == currentRaptorSpeed;
    }

    public SelenideElement getIssueAtIndex(int index){
        return issueList.get(index);
    }

    public List<String> getAllIssues() {
        var issues = new ArrayList<String>();
        issueList.stream().forEach(issue -> issues.add(issue.getText()));
        return issues;
    }

    public boolean isRaptorWearingAccessory(String accessoryName) {
        if ($(String.format("img[alt='%s']", accessoryName)).isDisplayed()){
            return true;
        }
        return false;
    }

    public int getCurrentVelocity(){
        var raptorSpeedString = raptorSpeedField.getText();
        return Integer.parseInt(raptorSpeedString.replaceAll("[\\D]", ""));
    }

}
