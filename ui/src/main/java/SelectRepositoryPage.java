import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SelectRepositoryPage extends BasePage {

    private final SelenideElement selectRepositoryHeader = $x("//h1[contains(text(),'Choose')]");

    private final SelenideElement selectButton = $("button[id='selectRepoButton']");

    public SelectRepositoryPage() {
        verifyIsOpened();
    }

    public void verifyIsOpened() {
        selectRepositoryHeader.shouldBe(Condition.visible);
    }

    public SelectRepositoryPage selectRepositoryByName(String name){
        $(format("td[id='%s']", name)).click();
        return this;
    }

    public ExtensionPage submitRepositorySelection(){
        selectButton.click();
        return new ExtensionPage();
    }

}
