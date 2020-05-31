import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChangeAccessoriesTest extends BaseWebTest {

    VelocityRaptorSettingsPage raptorSettingsPage;

    @BeforeMethod
    public void initTestData() {
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

    @Test
    public void testChangeBackGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.BACK)
            .selectAccessoryByName(AccessoryNames.BACK_ANGEL_WING)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory(AccessoryNames.BACK_ANGEL_WING));
    }


    @Test
    public void testChangeTailGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.TAIL)
            .selectAccessoryByName(AccessoryNames.SPIKED_ORANGE_TAIL)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory(AccessoryNames.SPIKED_ORANGE_TAIL));
    }

    @Test
    public void testChangeHandGear() {
        extensionPage = raptorSettingsPage.setAccessoryType(AccessoryTypes.HAND)
            .selectAccessoryByName(AccessoryNames.SABER)
            .backToExtensionPage();
        assertTrue(extensionPage.isRaptorWearingAccessory(AccessoryNames.SABER));
    }

}

