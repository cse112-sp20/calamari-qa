import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeAccessoriesTest extends BaseWebTest {

    VelocityRaptorSettingsPage raptorSettingsPage;

    @BeforeTest
    public void initTestData(){
        raptorSettingsPage = extensionPage.openSettingsPage()
            .openVelocityRaptorSettingsPage();
    }

    @Test
    public void testChangeHeadGear() {
    }

    @Test
    public void testChangeBackGear() {

    }

    @Test
    public void testChangeTailGear() {

    }

    @Test
    public void testChangeHandGear() {

    }

}

