import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HelpPage extends SettingsPage {

    private final SelenideElement helpHeader = $x("");

    public HelpPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        helpHeader.shouldBe(Condition.visible);
    }

}
