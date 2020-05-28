import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    // TODO: Change to VelocityRaptor later
    private static final String extensionLink = "chrome-extension://bcpdbeigkofnegjinbifbjnliefpdaec/root/html/setup/auth.html";

    public abstract void verifyIsOpened();

    public static ExtensionPage openExtension() {
        getWebDriver().get(extensionLink);
        return new ExtensionPage();
    }

}
