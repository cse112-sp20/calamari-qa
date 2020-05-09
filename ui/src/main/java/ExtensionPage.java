import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// This is the main Page Object for our extention
public class ExtensionPage {

    // TODO: Insert all elements and functions for our extension here

    private SelenideElement extensionHeader = $x("");

    public ExtensionPage(){
        extensionHeader.shouldBe(Condition.visible);
    }

}
