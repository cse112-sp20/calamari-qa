import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class GithubAuthenticationPage extends BasePage {

    private final SelenideElement githubHeader = $("webview");

    private final String usernameFieldSelector = "input[name='login']";

    private final String passwordFieldSelector = "input[type='password']";

    private final String loginButtonSelector = "input[type='submit']";

    private final String authorizeButtonSelector = "button[name='authorize']";

    private final String emailCodeSelector = "input[placeholder='6-digit code']";

    private final String submitVerificationCodeSelector = "";

    public GithubAuthenticationPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        githubHeader.shouldBe(Condition.exist);
    }

    public boolean isOpened() {
        return githubHeader.isDisplayed();
    }

    public GithubAuthenticationPage setUsername(String username) {
        executeJavaScript(format("document.querySelector(\"webview\").executeScript({code: \"" +
            "document.querySelector(\\\"%s\\\").value = '%s'\"})", usernameFieldSelector, username));
        return this;
    }

    public GithubAuthenticationPage setPassword(String password) {
        executeJavaScript(format("document.querySelector(\"webview\").executeScript({code: \"" +
            "document.querySelector(\\\"%s\\\").value = '%s'\"})", passwordFieldSelector, password));
        return this;
    }

    public GithubAuthenticationPage clickLogin(){
        executeJavaScript(format("document.querySelector(\"webview\").executeScript({code: \"" +
            "document.querySelector(\\\"%s\\\").click()\"})", loginButtonSelector));
        return this;
    }

    public RaptorNamingPage authorizeGithub() {
        executeJavaScript(format("document.querySelector(\"webview\").executeScript({code: \"" +
            "document.querySelector(\\\"%s\\\").click()\"})", authorizeButtonSelector));
        var handles = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(handles.get(0));
        return new RaptorNamingPage();
    }

    public GithubAuthenticationPage sendVerificationCode(String emailCode) {
        executeJavaScript(format("document.querySelector(\"webview\").executeScript({code: \"" +
            "document.querySelector(\\\"%s\\\").value = '%s'\"})", emailCodeSelector, emailCode));
        executeJavaScript(format("document.querySelector(\"webview\").executeScript({code: \"" +
            "document.querySelector(\\\"%s\\\").click()\"})", submitVerificationCodeSelector));
        return this;
    }

}
