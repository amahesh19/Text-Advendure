import java.util.HashMap;
import java.util.Map;

public class main {	
	public static void main(String args[]) {
		Map<String, Scene> Scenes = new HashMap<String, Scene>();
		Map<String, Boolean> CheckPoints = new HashMap<String, Boolean>();
		String currentSceneName;
		
		Game newGame = new Game(Scenes, CheckPoints, currentScene); 
		
		newGame.start();
		return;
	}
}
