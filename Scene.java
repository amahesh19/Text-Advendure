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


public String getSceneDescription(Scene scene){
    String returnString = "";
    Text text;
    ArrayList<Text> description;
    ArrayList<CheckpointQuery> checkList;
    CheckpointQuery check;
    
    boolean checkVal;
    for (int currentLine = 0, currentLine < description.size(), currentLine++){
        text = description.get(currentLine);
        checkList = text.getCheckpointsRequired();
        checkVal = True;
        for (int current = 0, j < check.size(), j++){
            check = checkList.get(j);
            if (! (check.get(j).getWantedValue() == CheckpointDictionary.get(check.getCheckpointName()))){
                checkVal = False;
            }
        }
        if (checkVal){
            returnString.concat("\n".concat(text.getTrueText());
        }
        else{
            returnString.concat("\n".concat(text.getTrueText()));
        }
    }
    return returnString;
}