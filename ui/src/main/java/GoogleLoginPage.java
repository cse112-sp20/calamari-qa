import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleLoginPage extends BasePage {

    private final SelenideElement loginPageHeader = $x("//h1[contains(text(),'Sign in to Chrome')]");

    private final SelenideElement emailField = $x("//input[@id='Email']");

    private final SelenideElement passwordField = $x("//input[@id='Passwd']");

    private final SelenideElement nextButton = $x("//input[@id='next']");

    private final SelenideElement signInButton = $x("//input[@id='signIn']");

    private final SelenideElement welcomeHeader = $x("//h1[contains(text(),'Welcome')]");

    public GoogleLoginPage(){
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        loginPageHeader.shouldBe(Condition.visible);
    }

    public void loginAsUser(String email, String password){
        emailField.setValue(email);
        nextButton.click();
        passwordField.setValue(password);
        signInButton.click();
    }

    public boolean isOnWelcomePage(){
        return welcomeHeader.isDisplayed();
    }

}
