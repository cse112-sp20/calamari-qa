import org.testng.annotations.Test;

public class SettingsNavigationTest extends BaseWebTest {

    @Test
    public void testNavigateSettings(){
        // verifications are automatically done in constructors, so no need to assert here
        extensionPage.openSettingsPage()
            .openVelocityRaptorSettingsPage()
            .openMyTeamSettingsPage()
            .openGithubRepoSettings()
            .openGeneralSettingsPage()
            .backToExtensionPage();
    }

}
