import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONException;

public class main {	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws JSONException {
		HashMap<String, Scene> Scenes = new HashMap<String, Scene>();
		HashMap<String, Boolean> CheckPoints = new HashMap<String, Boolean>();
		String currentSceneName;
		String filename;
		Scanner input = new Scanner(System.in);
        System.out.println("Enter your filename: ");
        filename = input.next();
		
		ReadJSONFile parser = new ReadJSONFile(filename);
		System.out.print("\nFile loaded!\n\n");
		
		currentSceneName = parser.getFirstScene();
		CheckPoints = parser.getCheckpoints();
		Scenes = parser.getScenes();
		
//parse here

		Game newGame = new Game(Scenes, CheckPoints, currentSceneName); 
		
		newGame.start();
		System.exit(0);
	}
}
