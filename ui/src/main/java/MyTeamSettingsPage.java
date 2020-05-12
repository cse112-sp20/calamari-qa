import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyTeamSettingsPage extends SettingsPage {

    private final SelenideElement myTeamHeader = $x("");

    public MyTeamSettingsPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        myTeamHeader.shouldBe(Condition.visible);
    }

}