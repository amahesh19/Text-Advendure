import java.io.FileNotFoundException;
import org.json.JSONTokener;
import java.io.InputStream;
import java.util.HashMap;

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.FileInputStream;

public class ReadJSONFile {
	private JSONObject json;
	
	public ReadJSONFile(String filename){
		// TODO make this assign a json object reference in variable json
		
		try {
			
			InputStream is = new FileInputStream(filename);
			JSONTokener jT = new JSONTokener(is);
			json = (JSONObject) jT.nextValue();
			

		}
		catch(FileNotFoundException e) { e.printStackTrace();}
		catch(Exception e) { e.printStackTrace();}
	}
	
	public String getFirstScene() throws JSONException {
		String firstScene = (String) json.get("StartingScene");
		return firstScene;
	}
	
	public HashMap<String, Boolean> getCheckpoints() throws JSONException{
		HashMap<String, Boolean> checkPointsList = new HashMap<String, Boolean>();
		JSONArray array = (JSONArray) json.get("CheckpointNames");
		
		for (int i = 0; i < array.length(); i++) { //get the list of checkpoints and their values
			JSONObject entry = array.getJSONObject(i);
			checkPointsList.put(entry.getString("Name"), entry.getBoolean("Value"));
		}	
		
		return checkPointsList;
	}
	
	public HashMap<String, Scene> getScenes() throws JSONException{
		HashMap<String, Scene> SceneList = new HashMap<String, Scene>();
		JSONArray sceneArray = (JSONArray) json.get("Scenes");
		JSONObject ChoiceFinder = (JSONObject) json.get("Choices");
		JSONObject TextFinder = (JSONObject) json.get("Text");
		
		JSONObject TextObject;
		JSONObject ChoiceObject;
		
		
		JSONArray TextArray;
		String textName;
		
		JSONArray ChoiceArray;
		
		ArrayList<Text> textList;
		ArrayList<Choice> choiceList;
		JSONObject scene;
		String name;
		
		String TrueText;
		String FalseText;
		
		ArrayList<CheckpointQuery> cpqList;
		JSONArray cpqArray;
		
		String checkPointName;
		Boolean checkPointValue;
		JSONObject cpqObj;
		
		String OptionText;
		String Desc;
		String Scene;
		ArrayList<String> cpqStringList;
		String ChoiceName;
		
		
		for (int i = 0; i < sceneArray.length(); i++) { //Here we parse the list of scenes.
			scene = (JSONObject) sceneArray.getJSONObject(i);
			TextArray = (JSONArray) scene.get("Description");
			ChoiceArray = (JSONArray) scene.get("Choices");
			
			name = (String) scene.getString("Name");
			
			cpqStringList = new ArrayList<String>();
			
			
			
			
			
			
			
			textList = new ArrayList<Text>();
			for (int j = 0; j < TextArray.length(); j++) { //Here we parse the list of Text objects for each scene.
				textName = (String) TextArray.getString(j);
				TextObject = (JSONObject) TextFinder.getJSONObject(textName);
				
				TrueText = (String) TextObject.getString("TrueText");
				FalseText = (String) TextObject.getString("FalseText");
				
				cpqArray = (JSONArray) TextObject.getJSONArray("Checkpoints");
				
				cpqList = new ArrayList<CheckpointQuery>();
				
				for (int k = 0; k < cpqArray.length(); k++) { //parses its checkpoints
					cpqObj = (JSONObject) cpqArray.getJSONObject(k);
					checkPointName = (String) cpqObj.getString("Name");
					checkPointValue = (Boolean) cpqObj.getBoolean("Value");
					cpqList.add(new CheckpointQuery(checkPointName, checkPointValue));
				}
				textList.add(new Text(TrueText, FalseText, cpqList));
			}
			
			
			choiceList = new ArrayList<Choice>();
			for (int j = 0; j < ChoiceArray.length(); j++) { //Parse list of choices
				ChoiceName = (String) ChoiceArray.getString(j);
				ChoiceObject = (JSONObject) ChoiceFinder.getJSONObject(ChoiceName);
				
				OptionText = (String) ChoiceObject.getString("OptionText");
				Desc = (String) ChoiceObject.getString("Description");
				Scene = (String) ChoiceObject.getString("Scene");
				
				cpqArray = (JSONArray) ChoiceObject.getJSONArray("Checkpoints");
				cpqList = new ArrayList<CheckpointQuery>();
				
				for (int k = 0; k < cpqArray.length(); k++) { //gets all the checkpoints needed for this choice.
					cpqObj = (JSONObject) cpqArray.getJSONObject(k);
					checkPointName = (String) cpqObj.getString("Name");
					checkPointValue = (Boolean) cpqObj.getBoolean("Value");
					cpqList.add(new CheckpointQuery(checkPointName, checkPointValue));
				}
				
				cpqArray = (JSONArray) ChoiceObject.getJSONArray("FlipCheckpoints");
				
				for (int k = 0; k < cpqArray.length(); k++) {
					cpqStringList.add((String) cpqArray.getString(k));
				}
				choiceList.add(new Choice(OptionText, Desc, cpqStringList, Scene, cpqList));
			}
			SceneList.put(name, new Scene(textList, choiceList));
		}
		
		
		return SceneList;
	}

}
