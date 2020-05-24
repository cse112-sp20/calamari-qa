import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChangeAccessoriesTest extends BaseWebTest {

    VelocityRaptorSettingsPage raptorSettingsPage;

    @BeforeTest
    public void initTestData(){
        raptorSettingsPage = extensionPage.openSettingsPage()
            .openVelocityRaptorSettingsPage();
    }

    @Test
    public void testChangeHeadGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.HEAD)
            .selectAccessoryByName(AccessoryNames.MAGIC_HAT)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory(AccessoryNames.MAGIC_HAT));
    }

    /*
    @Test
    public void testChangeBackGear() {
        raptorSettingsPage.setAccessoryType(AccessoryTypes.BACK);
    }

     */

    @Test
    public void testChangeTailGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.TAIL)
            .selectAccessoryByName(AccessoryNames.SPIKED_GREEN_TAIL)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory(AccessoryNames.SPIKED_GREEN_TAIL));
    }

    @Test
    public void testChangeHandGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.HANDS)
            .selectAccessoryByName(AccessoryNames.SABER)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory(AccessoryNames.SABER));
    }

}

