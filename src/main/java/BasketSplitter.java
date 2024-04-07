import java.util.*;

public class BasketSplitter {
    private Map<String, List<String>> deliveryOptions;

    private Map<String, Integer> deliveryOptionFrequency = new HashMap<>();
    private Map<String, List<String>> deliveryItems = new HashMap<>();

    public BasketSplitter(String absolutePathToConfigFile) {
        this.deliveryOptions = ConfigLoader.loadConfig(absolutePathToConfigFile);
    }

    public Map<String, List<String>> split(List<String> items) {
        mapItemsAndCalculateFrequency(items);
        return sortAndFilterResults(new ArrayList<>(items));
    }

    private void mapItemsAndCalculateFrequency(List<String> items) {
        for (String item : items) {
            if (deliveryOptions.containsKey(item)) {
                List<String> methods = deliveryOptions.get(item);
                for (String method : methods) {
                    deliveryOptionFrequency.put(method, deliveryOptionFrequency.getOrDefault(method, 0) + 1);
                    deliveryItems.computeIfAbsent(method, k -> new ArrayList<>()).add(item);
                }
            }
        }
    }

    private Map<String, List<String>> sortAndFilterResults(List<String> items) {
        List<Map.Entry<String, Integer>> sortedMethods = new ArrayList<>(deliveryOptionFrequency.entrySet());
        sortedMethods.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sortedMethods) {
            String method = entry.getKey();
            List<String> toAssign = filterAndRemoveAssignedItems(deliveryItems.get(method), items);
            if (!toAssign.isEmpty()) {
                result.put(method, toAssign);
            }
        }
        return result;
    }

    private List<String> filterAndRemoveAssignedItems(List<String> methodItems, List<String> items) {
        List<String> toAssign = new ArrayList<>();
        for (String item : methodItems) {
            if (items.contains(item)) {
                toAssign.add(item);
                items.remove(item);
            }
        }
        return toAssign;
    }

}



