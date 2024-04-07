
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigLoaderTest {

    @Test
    void loadConfigSuccessfully() {
        String testFilePath = "src/resources/config.json";
        Map<String, List<String>> config = ConfigLoader.loadConfig(testFilePath);
        assertNotNull(config, "Config should not be null");
        assertFalse(config.isEmpty(), "Config should not be empty");
    }

    @Test
    void getAllItems() {
        String testFilePath = "src/resources/config.json";
        Map<String, List<String>> config = ConfigLoader.loadConfig(testFilePath);
        assertTrue(config.size() == 100, "The config should have 100 items");
    }



}
