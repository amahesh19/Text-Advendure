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