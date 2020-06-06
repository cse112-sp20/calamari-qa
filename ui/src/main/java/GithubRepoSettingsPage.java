import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class GithubRepoSettingsPage extends SettingsPage {

    private final SelenideElement githubRepoSettingsHeader = $x("//div[contains(text(),'Repositories')]");

    private final SelenideElement selectButton = $("button[id='selectRepoButton']");

    public GithubRepoSettingsPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        githubRepoSettingsHeader.shouldBe(Condition.visible);
    }

    public GithubRepoSettingsPage setGithubRepository(String repository){
        $(format("td[id='%s']", repository)).click();
        selectButton.click();
        return this;
    }

}
