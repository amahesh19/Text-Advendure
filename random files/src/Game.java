import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
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
	
	public String getTextString(Text text){
	    ArrayList<CheckpointQuery> checkList = text.getCheckpointsRequired();
	    CheckpointQuery check;
	    boolean checkVal = true;
	    /**for (int j = 0; j < checkList.size(); j++){
	        check = checkList.get(j);
	        if (check.getWantedValue() != CheckPoints.get(check.getCheckpointName())){
	            checkVal = false;
	        }
	    }*/
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
	    boolean checkVal = true;
	    for (int j = 0; j < checkList.size(); j++){
	        check = checkList.get(j);
	        if (! (check.getWantedValue() == CheckPoints.get(check.getCheckpointName()))){
	            checkVal = false;
	        }
		}
		if (checkVal){
			System.out.print(Integer.toString(choiceNumber));
			System.out.print(") ");
			System.out.print(choice.getOptionText());
			System.out.print("\n");
		}
		return;
	}

	public void printSceneChoicesText(){
		ArrayList<Choice> choiceList = currentScene.getChoices();
		for (int i = 0; i < choiceList.size(); i++){
			printChoice(choiceList.get(i), i);
		}
		return;
	}

	public void printSceneDescription(){
		String returnString;
	    Text text;
	    ArrayList<Text> description = scene.getDescription();
	    System.out.print("We are in this function");
	    
	    for (int currentLine = 0; currentLine < description.size(); currentLine++){
	        text = description.get(currentLine);
	        returnString += "\n" + text;
	    }
	    System.out.print(returnString + "\n");
	    return;
	}

	public void flipValues(ArrayList<String> flipList){
		String currentCheckpoint;
		for (int i = 0; i < flipList.size(); i++){
			currentCheckpoint = flipList.get(i);
			if (CheckPoints.get(currentCheckpoint)){
				CheckPoints.replace(currentCheckpoint, false);
			}
			else{
				CheckPoints.replace(currentCheckpoint, true);
			}
		}
		return;
	}

	public int getUserInput(ArrayList<Choice> choiceList){
		Scanner input = new Scanner(System.in);
		int number;
        System.out.println("Enter choice: ");
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
		int userIn;
		Choice runChoice;
		ArrayList<String> flipList;

		while(! gameOver){
			printSceneDescription();
			printSceneChoicesText();
			userIn = getUserInput(currentScene.getChoices());
			if (userIn == -1){
				System.out.print("\nClosing game. Thanks for playing!\n");
				endGame();
			}
			else if (userIn == -2){
				System.out.print("Please enter a valid choice. \n");
			}
			else{
				runChoice = currentScene.getChoices().get(userIn);
				System.out.print(runChoice.getDescription() + "\n");
				flipList = runChoice.getFlipCheckpoints();
				flipValues(flipList);
				currentScene = Scenes.get(runChoice.getScene());
			}
		}
		return;
	}
	
}
