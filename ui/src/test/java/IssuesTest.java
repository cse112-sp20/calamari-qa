import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class IssuesTest extends BaseWebTest {

    private final String unassignedIssue = "Unassigned";

    @Test
    public void testCloseIssue(){
        var issuesBefore = extensionPage.getAllIssues();
        extensionPage
            .closeIssueAtIndex(0);
        var issuesAfter = extensionPage.getAllIssues();
        assertNotEquals(issuesAfter.size(), issuesBefore.size());
    }


    @Test
    public void testIssueNotAssignedDoesNotAppear(){
        var issues = extensionPage.getAllIssues();
        issues.forEach(issue -> assertNotEquals(issue, unassignedIssue));
    }

}
