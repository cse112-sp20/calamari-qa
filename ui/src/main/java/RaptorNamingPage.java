import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RaptorNamingPage extends BasePage {

    private final SelenideElement raptorNamingPageHeader = $("img[alt='Default Raptor']");

    private final SelenideElement raptorNameField = $("input[name='raptorName']");

    private final SelenideElement submitButton = $("button[id='raptorNameSubmit']");

    public RaptorNamingPage(){
        verifyIsOpened();
    }

    public void verifyIsOpened(){
        raptorNamingPageHeader.shouldBe(Condition.visible);
    }

    public RaptorNamingPage setRaptorName(String name){
        raptorNameField.setValue(name);
        return this;
    }

    public SelectRepositoryPage submitName(){
        submitButton.click();
        return new SelectRepositoryPage();
    }

}
