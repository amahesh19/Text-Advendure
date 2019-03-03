import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

public class main {	
	public static void main(String args[]) throws JSONException {
		HashMap<String, Scene> Scenes = new HashMap<String, Scene>();
		HashMap<String, Boolean> CheckPoints = new HashMap<String, Boolean>();
		String currentSceneName;
		
		ReadJSONFile parser = new ReadJSONFile("PrototypeGame.json");
		
		currentSceneName = parser.getFirstScene();
		CheckPoints = parser.getCheckpoints();
		Scenes = parser.getScenes();
		
//parse here

		Game newGame = new Game(Scenes, CheckPoints, currentSceneName); 
		
		newGame.start();
		return;
	}
}
