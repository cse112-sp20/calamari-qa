import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LinkToGithubPage extends BasePage {

    public SelenideElement linkToGithubButton = $("button[id='signin']");

    public LinkToGithubPage(){
        verifyIsOpened();
    }

    public void verifyIsOpened(){
        linkToGithubButton.shouldBe(Condition.visible);
    }

    public GithubAuthenticationPage beginLinkToGithub() throws InterruptedException {
        linkToGithubButton.click();
        Thread.sleep(5000);
        var handles = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(handles.get(1));
        return new GithubAuthenticationPage();
    }

}

