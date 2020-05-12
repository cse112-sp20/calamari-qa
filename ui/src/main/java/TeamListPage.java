import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TeamListPage extends BasePage {

    private final SelenideElement teamListHeader = $x("");

    public TeamListPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        teamListHeader.shouldBe(Condition.visible);
    }

}
