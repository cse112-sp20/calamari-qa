import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChangeRepositoryTest extends BaseWebTest {

    VelocityRaptorSettingsPage raptorSettingsPage;

    @BeforeMethod
    public void initTestData(){
        raptorSettingsPage = extensionPage.openSettingsPage()
                .openVelocityRaptorSettingsPage();
    }

    @Test
    public void testNavigateSettings(){
        // verifications are automatically done in constructors, so no need to assert here
        extensionPage.openSettingsPage()
                .openVelocityRaptorSettingsPage()
                .openGithubRepoSettings();
    }

}
