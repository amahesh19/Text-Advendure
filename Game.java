import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Game {
	
	private Map<String, Scene> Scenes = new HashMap<String, Scene>();
	private Map<String, Boolean> CheckPoints = new HashMap<String, Boolean>();
	private boolean gameOver;
	
	public Game(Map<String, Scene> Scenes, Map<String, Boolean> CheckPoints) {
		setScenes(Scenes);
		setCheckPoints(CheckPoints);
	}
	
	public void start() {
		this.gameOver = false; 
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
	}
	
	public boolean CheckPointAvaliable(String Name) {
		return this.CheckPoints.get(Name);
	}
	
	public String getTextString(Text text, Map<String, Boolean> CheckpointDictionary){
	    ArrayList<CheckpointQuery> checkList = text.getCheckpointsRequired();
	    CheckpointQuery check;
	    boolean checkVal = True;
	    for (int current = 0, j < check.size(), j++){
	        check = checkList.get(j);
	        if (! (check.get(j).getWantedValue() == CheckpointDictionary.get(check.getCheckpointName()))){
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

	public String getSceneDescription(Scene scene){
	    String returnString = "";
	    Text text;
	    ArrayList<Text> description;
	    
	    for (int currentLine = 0, currentLine < description.size(), currentLine++){
	        text = description.get(currentLine);
	        returnString.concat("\n".concat(getTextString(text, getCheckPoints());
	    }
	    return returnString;
	}
	
}
