package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class ReadSpecificNodes {

  public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode nodes = mapper.readTree(FileUtils.readFileToByteArray(new File("input.json")));
    List<JsonNode> fieldNames = nodes.findValues("sourceFieldName");
    System.out.println(nodes);
  }
}
