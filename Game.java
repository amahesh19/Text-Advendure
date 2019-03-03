import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Exception;
import java.util.Scanner;

public class Game {
	
	private Map<String, Scene> Scenes = new HashMap<String, Scene>();
	private Map<String, Boolean> CheckPoints = new HashMap<String, Boolean>();
	private boolean gameOver;
	private Scene currentScene;
	
	public Game(Map<String, Scene> ScenesArg, Map<String, Boolean> CheckPointsArg, String CurrentScene) {
		setScenes(ScenesArg);
		setCheckPoints(CheckPointsArg);
		currentScene = Scenes.get(CurrentScene);
	}
	
	public void start() {
		this.gameOver = false; 
		run();
		return;
	}
	
	public Scene getStartScene(String Name) {
		return this.Scenes.get(Name);
	}
	
	public Map<String, Scene> getScenes() {
		return this.Scenes;
	}
	
	public void setScenes(Map<String, Scene> Scenes) {
		this.Scenes = Scenes;
		return;
	}
	
	public void setCheckPoints(Map<String, Boolean> CheckPoints) {
		this.CheckPoints = CheckPoints;
		return;
	}
	
	public Map<String, Boolean> getCheckPoints() {
		return this.CheckPoints;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	public void endGame(){
		this.gameOver = true;
		return;
	}
	
	public boolean CheckPointAvaliable(String Name) {
		return this.CheckPoints.get(Name);
	}
	
	public String getTextString(Text text,){
	    ArrayList<CheckpointQuery> checkList = text.getCheckpointsRequired();
	    CheckpointQuery check;
	    boolean checkVal = True;
	    for (int j = 0; j < checkList.size(); j++){
	        check = checkList.get(j);
	        if (check.getWantedValue() != CheckPoints.get(check.getCheckpointName()))){
	            checkVal = False;
	        }
	    }
	    if (checkVal){
	        return text.getTrueText();
	    }
	    else{
	        return text.getFalseText();
	    }
	}

	public void printChoice(Choice choice, int choiceNumber){
		ArrayList<CheckpointQuery> checkList = choice.getCheckpoints();
	    CheckpointQuery check;
	    boolean checkVal = True;
	    for (int j = 0; j < checkList.size(); j++){
	        check = checkList.get(j);
	        if (! (check.getWantedValue() == CheckPoints.get(check.getCheckpointName()))){
	            checkVal = False;
	        }
		}
		if (checkVal){
			system.out.print(choiceNumber.toString());
			system.out.print(") ");
			system.out.print(choice.getOptionText());
			system.out.print("\n");
		}
		return;
	}

	public void printSceneChoicesText(){
		private ArrayList<Choice> choiceList = currentScene.getChoices();
		for (int i = 0; i < choiceList.size(); i++){
			printChoice(choiceList.get(i), i);
		}
		return;
	}

	public String getSceneDescription(Scene scene){
	    private String returnString = "";
	    private Text text;
	    private ArrayList<Text> description = scene.getDescription();
	    
	    for (int currentLine = 0, currentLine < description.size(), currentLine++){
	        text = description.get(currentLine);
	        returnString.concat("\n".concat(getTextString(text, getCheckPoints());
	    }
	    return returnString;
	}

	public void flipValues(ArrayList<String> flipList){
		String currentCheckpoint;
		for (int i = 0; i < flipList.size(); i++){
			currentCheckpoint = flipList.get(i);
			if (CheckPoints.get(currentCheckpoint)){
				CheckPoints.replace(currentCheckpoint, False);
			}
			else{
				CheckPoints.replace(currentCheckpoint, True);
			}
		}
		return;
	}

	public int getUserInput(ArrayList<Choice> choiceList){
		Scanner input = new Scanner(system.in);
		int number;
        system.out.println("Enter choice: ");
        String choice = input.next();
        if (choice.equals("exit")){
            return -1;
		}
        else {
			try{
				number = Integer.parseInt(choice);
			} catch (Exception e) {
				return -2;
			}
			if(number > choiceList.size() || number < 0){
            	return -2;
        	}
        	else{
				return number;
			}
        }
    }

	public void run(){
		private int userIn;
		private Choice runChoice;
		private ArrayList<String> flipList;

		while(! gameOver){
			system.out.print(getSceneDescription(currentScene));
			printSceneChoicesText();
			userIn = getUserInput(currentScene.getChoices());
			if (userIn == -1){
				endGame();
			}
			else if (userIn == -2){
				system.out.print("Please enter a valid choice. \n");
			}
			else{
				runChoice = currentScene.getChoices().get(userIn);
				system.out.print(runChoice.getDescription());
				flipList = runChoice.getFlipCheckpoints();
				flipValues(flipList);
				currentScene = Scenes.get(runChoice.getScene());
			}
		}
		return;
	}
	
}
