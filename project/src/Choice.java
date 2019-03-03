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
