import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

import com.sun.javafx.collections.MappingChange.Map;

public class ReadJSONFile {
	
	private JSONParser parser;
	private JSONObject json;
	private Object obj;
	
	public ReadJSONFile(String filename){
		// TODO Auto-generated method stub
		parser = new JSONParser();
		
		try {
			obj = parser.parse(new FileReader(filename));
			json = (JSONObject) obj;
		}
		catch(FileNotFoundException e) { e.printStackTrace();}
		catch(IOException e) { e.printStackTrace();}
		catch(ParseException e) { e.printStackTrace();}
		catch(Exception e) { e.printStackTrace();}
	}
	
	public String getFirstScene() throws JSONException {
		String firstScene = (String) json.get("StartingScene");
		return firstScene;
	}
	
	public HashMap<String, Boolean> getCheckpoints() throws JSONException{
		HashMap<String, Boolean> checkPointsList = new HashMap<String, Boolean>();
		JSONArray array = (JSONArray) json.get("Checkpoints");
		
		for (int i = 0; i < array.length(); i++) {
			JSONObject entry = array.getJSONObject(i);
			checkPointsList.put(entry.getString("name"), entry.getBoolean("value"));
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
		String choiceName;
		
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
		
		
		for (int i = 0; i < sceneArray.length(); i++) {
			scene = (JSONObject) sceneArray.getJSONObject(i);
			TextArray = (JSONArray) scene.get("Description");
			ChoiceArray = (JSONArray) scene.get("Choices");
			
			name = (String) scene.getString("Name");
			
			cpqStringList = new ArrayList<String>();
			
			
			
			
			
			
			
			textList = new ArrayList<Text>();
			for (int j = 0; j < TextArray.length(); j++) {
				textName = (String) TextArray.getString(j);
				TextObject = (JSONObject) TextFinder.getJSONObject(textName);
				
				TrueText = (String) TextObject.getString("TrueText");
				FalseText = (String) TextObject.getString("FalseText");
				
				cpqArray = (JSONArray) TextObject.getJSONArray("Checkpoints");
				
				cpqList = new ArrayList<CheckpointQuery>();
				
				for (int k = 0; k < cpqArray.length(); k++) {
					cpqObj = (JSONObject) cpqArray.getJSONObject(k);
					checkPointName = (String) cpqObj.getString("Name");
					checkPointValue = (Boolean) cpqObj.getBoolean("Value");
					cpqList.add(new CheckpointQuery(checkPointName, checkPointValue));
				}
				textList.add(new Text(TrueText, FalseText, cpqList));
			}
			
			
			choiceList = new ArrayList<Choice>();
			for (int j = 0; j < ChoiceArray.length(); j++) {
				ChoiceName = (String) ChoiceArray.getString(j);
				ChoiceObject = (JSONObject) ChoiceFinder.getJSONObject(ChoiceName);
				
				OptionText = (String) ChoiceObject.getString("OptionText");
				Desc = (String) ChoiceObject.getString("Description");
				Scene = (String) ChoiceObject.getString("Scene");
				
				cpqArray = (JSONArray) ChoiceObject.getJSONArray("Checkpoints");
				cpqList = new ArrayList<CheckpointQuery>();
				
				for (int k = 0; k < cpqArray.length(); k++) {
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
