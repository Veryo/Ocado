import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BasketLoaderTest {

    @Test
    void loadConfigSuccessfullyForBasket1() {
        // Assuming the file exists and contains a valid JSON array
        String testFilePath = "src/resources/basket-1.json";
        List<String> items = BasketLoader.loadConfig(testFilePath);

        assertTrue(items.size()==6, "The basket should have 6 items");
    }


    @Test
    void loadConfigSuccessfullyForBasket2() {
        // Assuming the file exists and contains a valid JSON array
        String testFilePath = "src/resources/basket-2.json";
        List<String> items = BasketLoader.loadConfig(testFilePath);

        assertTrue(items.size()==17, "The basket should have 6 items");
    }
}
