import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// This is the main Page Object for our extention
public class ExtensionPage extends BasePage {

    private final SelenideElement extensionHeader = $x("");

    public ExtensionPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        extensionHeader.shouldBe(Condition.visible);
    }

    public SelenideElement getExtensionHeader(){
        return extensionHeader;
    }

}
