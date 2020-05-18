import org.testng.annotations.Test;

public class SettingsNavigationTest extends BaseWebTest {

    private String email = "andrewvelocityraptor@gmail.com";
    private String password = "andrewpassword";

    public void initTestData() {
        loginGoogleAndVerify(email, password);
    }

    @Test
    public void testNavigateSettings(){
        // verifications are automatically done in constructors, so no need to assert here
        googleLoginPage.openExtension()
            .openSettingsPage()
            .openVelocityRaptorSettingsPage()
            .openMyTeamSettingsPage()
            .openHelpPage()
            .openGeneralSettingsPage();
    }

}
