import java.util.ArrayList;


public class Scene {

    private String description;
    private ArrayList choices;

    public Scene(ArrayList descriptionArg, ArrayList choicesArg){
        description = descriptionArg;
        choices = choicesArg;
    }

    public ArrayList getChoices(){
        return choices;
    }

    public void setChoices(ArrayList newChoices){
        choices = newChoices;
    }

    public ArrayList getDescription(){
        return description;
    }

    public void setDescription(ArrayList newDescription){
        description = newDescription;
    }
}