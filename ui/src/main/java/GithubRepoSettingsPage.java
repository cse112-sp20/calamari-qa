import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GithubRepoSettingsPage extends SettingsPage {

    private final SelenideElement githubRepoSettingsHeader = $x("//div[contains(text(),'Repositories')]");

    public GithubRepoSettingsPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        githubRepoSettingsHeader.shouldBe(Condition.visible);
    }

}
