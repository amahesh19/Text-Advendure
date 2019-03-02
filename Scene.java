import java.util.ArrayList;


public class Scene {

    private ArrayList<Text> description;
    private ArrayList<Choice> choices;

    public Scene(ArrayList<Text> Description, ArrayList<Choice> Choices){
        description = Description;
        choices = Choices;
    }

    public ArrayList getChoices(){
        return choices;
    }

    public void setChoices(ArrayList newChoices){
        choices = newChoices;
    }

    public Arraylist<Text> getDescription(){ //returns the actual description of the scene based on checkpoints completed.
        return description;
    }

    public void setDescription(ArrayList<Text> Description){
        description = Description;
    }
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