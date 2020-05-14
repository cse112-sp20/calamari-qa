import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {

    // TODO: Change later, currently this refers to Chropath and not Velocity Raptor obviously
    private static final SelenideElement extensionHeader = $x("//title[contains(text(), 'Development tool')]");

    // must be implemented in extending classes
    public abstract void verifyIsOpened();

    public static ExtensionPage openExtension() {
        switchTo().frame(extensionHeader);
        return new ExtensionPage();
    }

}
