import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginGoogleTest extends BaseWebTest {

    private String email = "andrewvelocityraptor@gmail.com";
    private String password = "andrewpassword";

    @Test
    public void testLoginGoogle(){
        googleLoginPage.loginAsUser(email, password);
        assertTrue(googleLoginPage.isOnWelcomePage());
    }

    @Test
    public void openExtensionTest(){
        var extensionPage = googleLoginPage.openExtension();
        String hi = "hi";
    }

}
