import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.List;
public class ConfigLoader {
    public static Map<String, List<String>> loadConfig(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}