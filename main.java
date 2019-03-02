import java.util.HashMap;
import java.util.Map;

public class main {	
	public static void main(String args[]) {
		Map<String, SceneTest> Scenes = new HashMap<String, SceneTest>();
		Map<String, Boolean> CheckPoints = new HashMap<String, Boolean>();
		Scene currentScene;
		
		Game newGame = new Game(Scenes, CheckPoints); 
		
		String startSceneName = null;
		newGame.start();
		currentScene = newGame.getStartScene(startSceneName);
		while (! newGame.isGameOver()) {
			
		}
	}
}
