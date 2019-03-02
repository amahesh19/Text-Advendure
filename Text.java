import java.util.ArrayList;

public class Text{
    private String trueText;
    private String falseText;
    private ArrayList<String> checkpointsRequired;

    public Text(String TrueText, String FalseText, ArrayList<String> CheckpointsRequired){
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

    public ArrayList<String> getCheckpointsRequired(){
        return checkpointsRequired;
    }

    public void setCheckpointsRequired(ArrayList<String> newCheckpointsRequired){
        checkpointsRequired = newCheckpointsRequired;
    }

}