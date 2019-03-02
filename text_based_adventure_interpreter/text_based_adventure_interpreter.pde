import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class CheckpointQuery{
    private String checkpointName;
    private boolean wantedValue;

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
  
  JSONObject texts = json.getJSONObject("Text");
  for(Object textKey: texts.keys()) {
     println(textKey); 
     JSONObject text =  texts.getJSONObject((String) textKey);
     String TrueText = text.getString("TrueText");
     String FalseText = text.getString("FalseText");
     println(TrueText, FalseText);
     //ArrayList<CheckpointQuery> checkpointsRequired;
  }
  
  
  

  println(hm);
}
