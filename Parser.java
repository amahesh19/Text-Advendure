import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

class Parser {

   public static void main(String[] args) {
      JSONParser parser = new JSONParser();

      try {
         Object obj = parser.parse(new FileReader("PrototypeGame.json"));

         JSONObject jsonObject = (JSONObject) obj;
         // System.out.println(jsonObject);

         JSONObject cp = (JSONObject) jsonObject.get("Checkpoints");
         // Set<String> keys = cp.keySet();
         System.out.println(cp);
         // System.out.println(keys);

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } catch (ParseException e) {
         e.printStackTrace();
     }
   }
}