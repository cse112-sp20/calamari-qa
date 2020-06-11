import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    private static final String extensionLink = "chrome-extension://gmkfadagefbkamioikldlidjfpgaenja/root/html/setup/auth.html";

    public abstract void verifyIsOpened();

    public static void openExtension() {
        getWebDriver().get(extensionLink);
        Selenide.refresh();
    }

}
