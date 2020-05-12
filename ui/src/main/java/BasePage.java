import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    private final SelenideElement extensionButton = $x("");

    // must be implemented in extending classes
    public abstract void verifyIsOpened();

    public ExtensionPage openExtension() {
        extensionButton.click();
        return new ExtensionPage();
    }

    public void closeExtension() {
        extensionButton.click();
    }

}
