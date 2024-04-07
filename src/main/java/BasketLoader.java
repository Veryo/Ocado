import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BasketLoader {
    public static List<String> loadConfig(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), List.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
