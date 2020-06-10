import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage extends BasePage {

    private final SelenideElement loginPageHeader = $x("//span[contains(text(),'Sign in')]");

    private final SelenideElement emailField = $("input[type='email']");

    private final SelenideElement passwordField = $("input[type='password']");

    private final SelenideElement nextButton = $x("//span[contains(text(),'Next')]");

    private final ElementsCollection githubEmails = $$x("//span[@email='noreply@github.com']");

    public GooglePage(){
        verifyIsOpened();
    }

    @Override
    public void verifyIsOpened() {
        loginPageHeader.shouldBe(Condition.visible);
    }

    public void loginAsUser(String email, String password) throws InterruptedException {
        emailField.setValue(email);
        nextButton.click();
        Thread.sleep(3000);
        passwordField.setValue(password);
        nextButton.click();
        Thread.sleep(3000);
    }

    public String getGithubVerificationCode(){
        githubEmails.get(0).parent().parent().parent().click();
        var verificationCodeElements = $$x("//*[contains(text(),'Verification')]");
        var verificationCodeEmail = verificationCodeElements.get(verificationCodeElements.size()-1).getText();
        return verificationCodeEmail.substring(verificationCodeEmail.length()-6);
    }

}