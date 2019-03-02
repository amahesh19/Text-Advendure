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
        return;
    }

    public Arraylist<Text> getDescription(){ //returns the actual description of the scene based on checkpoints completed.
        return description;
    }

    public void setDescription(ArrayList<Text> Description){
        description = Description;
        return;
    }
}