import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BasketSplitterTest {
    @Test
    void itemsCorrentlyAssignedForBasket1() {

        BasketSplitter splitter = new BasketSplitter("src/resources/config.json");
        String testFilePath = "src/resources/basket-1.json";
        List<String> items = BasketLoader.loadConfig(testFilePath);
        Map<String, List<String>> actualResult = splitter.split(items);
        Map<String, List<String>> expectedResult = new HashMap<>();
        expectedResult.put("Courier", List.of("Cocoa Butter", "Tart - Raisin And Pecan", "Table Cloth 54x72 White", "Flower - Daisies", "Cookies - Englishbay Wht"));
        expectedResult.put("Mailbox delivery", List.of("Fond - Chocolate"));

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void itemsCorrentlyAssignedForBasket2() {

        BasketSplitter splitter = new BasketSplitter("src/resources/config.json");
        String testFilePath = "src/resources/basket-2.json";
        List<String> items = BasketLoader.loadConfig(testFilePath);
        Map<String, List<String>> actualResult = splitter.split(items);
        Map<String, List<String>> expectedResult = new HashMap<>();

        expectedResult.put("Pick-up point", List.of("Sauce - Mint", "Numi - Assorted Teas"));
        expectedResult.put("Same day delivery", List.of("Garlic - Peeled"));
        expectedResult.put("Courier", List.of("Cake - Miini Cheesecake Cherry"));
        expectedResult.put("Express Collection", List.of("Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Apples - Spartan", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSingleItemSingleDeliveryOption() {
        String testConfigPath = "src/resources/config.json";
        BasketSplitter basketSplitter = new BasketSplitter(testConfigPath);
        List<String> items = Collections.singletonList("Garlic - Peeled");
        Map<String, List<String>> expected = Collections.singletonMap("Same day delivery", Collections.singletonList("Garlic - Peeled"));
        assertEquals(expected, basketSplitter.split(items));
    }

    @Test
    void testEmptyItemList() {
        String testConfigPath = "src/resources/config.json";
        BasketSplitter basketSplitter = new BasketSplitter(testConfigPath);
        List<String> items = Collections.emptyList();
        assertTrue(basketSplitter.split(items).isEmpty());
    }
}
