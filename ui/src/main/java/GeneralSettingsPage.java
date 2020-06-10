import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GeneralSettingsPage extends SettingsPage {

    private final SelenideElement generalSettingsHeader = $x("//div[contains(text(),'General')]");

    private final SelenideElement resetButton = $("button[id='remove_all']");

    public GeneralSettingsPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        generalSettingsHeader.shouldBe(Condition.visible);
    }

    public RaptorNamingPage resetVelocityRaptor(){
        resetButton.click();
        return new RaptorNamingPage();
    }

}
