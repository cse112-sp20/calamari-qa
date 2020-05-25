import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChangeAccessoriesTest extends BaseWebTest {

    VelocityRaptorSettingsPage raptorSettingsPage;

    @BeforeMethod
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
    } */


    @Test
    public void testChangeTailGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.TAIL)
            .selectAccessoryByName(AccessoryNames.SPIKED_ORANGE_TAIL)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory("Spiked Orange Tail Accesory"));
    }

    @Test
    public void testChangeHandGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.HAND)
            .selectAccessoryByName(AccessoryNames.SABER)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory("Saber Accesory"));
    }

}

