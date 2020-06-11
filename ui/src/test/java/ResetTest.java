import org.testng.annotations.Test;

public class ResetTest extends BaseWebTest {

    @Test
    public void testReset(){
        extensionPage.openSettingsPage()
            .resetVelocityRaptor();
    }

}
