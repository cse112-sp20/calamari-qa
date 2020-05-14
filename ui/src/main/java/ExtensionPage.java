import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ExtensionPage extends BasePage {

    // TODO: Replace header with Velocity Raptor header
    private final SelenideElement extensionHeader = $x("//img[@class='logo']");

    public ExtensionPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        extensionHeader.shouldBe(Condition.visible);
    }

}
