import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class VelocityTest extends BaseWebTest {

    @Test
    public void testVelocityIncreasesWhenClosingIssues(){
        extensionPage.closeIssueAtIndex(0)
            .openSettingsPage()
            .backToExtensionPage();
        var oldVelocity = extensionPage.getCurrentVelocity();
        extensionPage.closeIssueAtIndex(0)
            .openSettingsPage()
            .backToExtensionPage();
        var newVelocity = extensionPage.getCurrentVelocity();
        assertTrue(oldVelocity < newVelocity);
    }

}
