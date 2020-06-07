import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class VelocityTest extends BaseWebTest {

    @Test
    public void testVelocityIncreasesWhenClosingIssues(){
        extensionPage.closeIssueAtIndex(0);
        var oldVelocity = extensionPage.getCurrentVelocity();
        extensionPage.closeIssueAtIndex(0);
        var newVelocity = extensionPage.getCurrentVelocity();
        assertTrue(oldVelocity < newVelocity);
    }

}
