import java.util.ArrayList;

public class Choice{
    private String optionText;
    private String description;
    private ArrayList flipCheckpoints;
    private String scene;

    public Choice(String oT, String d, ArrayList cR, ArrayList fC){
        optionText = oT;
        description = d;
        checkpointsRequired = cR;
        flipCheckpoints = fC;
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

    public ArrayList getFlipCheckpoints(){
        return flipCheckpoints;
    }

    public void setFlipCheckpoints(ArrayList newFC){
        flipCheckpoints = newFC;
    }

    public String getScene(){
        return scene;
    }

    public void setScene(String newScene){
        scene = newScene;
    }
}
