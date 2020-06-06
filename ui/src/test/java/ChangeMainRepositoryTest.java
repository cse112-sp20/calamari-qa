import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class ChangeMainRepositoryTest extends BaseWebTest {

    @Test
    public void testChangeMainRepository(){
        var issuesBefore = extensionPage.getAllIssues();
        extensionPage.openSettingsPage()
            .openGithubRepoSettings()
            .setGithubRepository(Repositoriies.TEST_REPOSITORY_TWO);
        var currIssues = extensionPage.getAllIssues();
        assertNotEquals(issuesBefore.get(0), currIssues.get(0));
    }

}
