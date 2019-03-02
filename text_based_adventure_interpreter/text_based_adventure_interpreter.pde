import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Choice{
    private String optionText;
    private String description;
    private ArrayList<CheckpointQuery> checkpoints;
    private ArrayList<String> flipCheckpoints;
    private String scene;

    public Choice(String oT, String d, ArrayList<String> fC, String sc, ArrayList<CheckpointQuery> Checkpoints){
        optionText = oT;
        description = d;
        flipCheckpoints = fC;
        scene = sc;
        checkpoints = Checkpoints;
    }

    public String getOptionText(){
        return optionText;
    }

    public void setOptionText(String newOption){
        optionText = newOption;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String newD){
        description = newD;
    }

    public ArrayList<String> getFlipCheckpoints(){
        return flipCheckpoints;
    }

    public void setFlipCheckpoints(ArrayList<String> newFC){
        flipCheckpoints = newFC;
    }

    public String getScene(){
        return scene;
    }

    public void setScene(String newScene){
        scene = newScene;
    }

    public ArrayList<CheckpointQuery> getCheckpoints(){
        return checkpoints;
    }

    public void setCheckpoints(ArrayList<CheckpointQuery> Checkpoints){
        checkpoints = Checkpoints;
    }
}

public class CheckpointQuery{
    private String checkpointName;
    private boolean wantedValue;

    public CheckpointQuery(String cN, boolean wV){
        checkpointName = cN;
        wantedValue = wV;
    }

    public String getCheckpointName(){
        return checkpointName;
    }

    public void setCheckpointName(String newCheckpointName){
        checkpointName = newCheckpointName;
    }

    public boolean getWantedValue(){
        return wantedValue;
    }

    public void setWantedValue(boolean newWantedValue){
        wantedValue = newWantedValue;
    }
}


public class Text{
    private String trueText;
    private String falseText;
    private ArrayList<CheckpointQuery> checkpointsRequired;

    public Text(String TrueText, String FalseText, ArrayList<CheckpointQuery> CheckpointsRequired){
        trueText = TrueText;
        falseText = FalseText;
        checkpointsRequired = CheckpointsRequired;
    }

    public String getTrueText(){
        return trueText;
    }

    public void setTrueText(String newTrueText){
        trueText = newTrueText;
    }

    public String getFalseText(){
        return falseText;
    }

    public void setFalseText(String newFalseText){
        falseText = newFalseText;
    }

    public ArrayList<CheckpointQuery> getCheckpointsRequired(){
        return checkpointsRequired;
    }

    public void setCheckpointsRequired(ArrayList<CheckpointQuery> newCheckpointsRequired){
        checkpointsRequired = newCheckpointsRequired;
    }
}

JSONObject json;

void setup() {
  json = loadJSONObject("../PrototypeGame.json");

  JSONObject flags = json.getJSONObject("Checkpoints");
  HashMap<String, Boolean> hm = new HashMap<String, Boolean>();

  //Checkpoints
  for (Object k: flags.keys()) {
    boolean b = flags.getBoolean((String) k);
    hm.put((String) k, b);
  }
  
  ArrayList<Text> textObjects = new ArrayList<Text>();
  
  JSONObject texts = json.getJSONObject("Text");
  for(Object textKey: texts.keys()) {
     JSONObject text =  texts.getJSONObject((String) textKey);
     String TrueText = text.getString("TrueText");
     String FalseText = text.getString("FalseText");
     
     JSONObject checkpoints = text.getJSONObject("Checkpoints");
     
     ArrayList<CheckpointQuery> cpqObjects = new ArrayList<CheckpointQuery>();
     for(Object checkpointName: checkpoints.keys()) {
         CheckpointQuery cpq = new CheckpointQuery((String) checkpointName, checkpoints.getBoolean((String) checkpointName));
         cpqObjects.add(0, cpq);
     }
     
     println(TrueText, FalseText, cpqObjects);
     
     Text textObject = new Text(TrueText, FalseText, cpqObjects);
     
     textObjects.add(0, textObject);
     
  }
  
  println(textObjects);
  
  //At this point we have hm, which is the hashmap of checkpoints and textObjects, which contains all of the text objects.

  //println(hm);
}
