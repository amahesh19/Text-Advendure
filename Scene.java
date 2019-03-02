


public class Scene {

    private String description;
    private ArrayList choices;

    public Scene(ArrayList description, ArrayList choices){

    }

    public ArrayList getChoices(){
        return this.choices;
    }

    public void setChoices(ArrayList newChoices){
        this.choices = newChoices;
    }

    public ArrayList getDescription(){
        return this.description;
    }

    public void setDescription(ArrayList newDescription){
        this.description = newDescription;
    }

}