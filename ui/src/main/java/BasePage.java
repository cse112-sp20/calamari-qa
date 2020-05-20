import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    // TODO: Change to VelocityRaptor later
    private final String extensionLink = "chrome-extension://giojfnbebmhbljceaghblhjabmamiieh/root/html/setup/auth.html";

    public abstract void verifyIsOpened();

    public ExtensionPage openExtension() {
        getWebDriver().get(extensionLink);
        return new ExtensionPage();
    }

}
