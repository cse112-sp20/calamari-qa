import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GithubAuthenticationPage extends BasePage {

    private final SelenideElement githubHeader = $x("");

    private final SelenideElement usernameField = $x("");

    private final SelenideElement passwordField = $x("");

    private final SelenideElement loginButton = $x("");

    public GithubAuthenticationPage() {
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        githubHeader.shouldBe(Condition.visible);
    }

    public GithubAuthenticationPage setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public GithubAuthenticationPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public GithubAuthenticationPage clickLogin(){
        loginButton.click();
        return this;
    }

    public void loginWithCredentials(String username, String password){
        this.setUsername(username)
            .setPassword(password)
            .clickLogin();
    }

}
