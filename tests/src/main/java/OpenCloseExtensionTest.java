import org.testng.annotations.Test;

public class OpenCloseExtensionTest extends BaseWebTest {

    @Test()
    public void testOpenCloseExtension() {
        ExtensionPage extensionPage = startPage.openExtension();
        extensionPage.closeExtension();
    }

}
