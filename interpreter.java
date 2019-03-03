import org.json.simple.JSONObject;

JSONObject json;

class interpreter{
    public static void main(String[] Args){
        json = loadJSONObject("../PrototypeGame.json");

        JSONObject flags = json.getJSONObject("Checkpoints");
        HashMap<String, Boolean> hm = new HashMap<String, Boolean>();

        //Checkpoints //Iterate over keys
        /** 
         for (Object k: flags.keys()) { for every key in checkpoints
            boolean b = flags.getBoolean((String) k); 
            hm.put((String) k, b); //insert that key and its boolean into the hashmap.
        }
        */

        for (int i = 0; i < flags.keys().size)

        
        ArrayList<Text> textObjects = new ArrayList<Text>();
        
        JSONObject texts = json.getJSONObject("Text");
        for(Object textKey: texts.keys()) {
            JSONObject text =  texts.getJSONObject((String) textKey);
            String TrueText = text.getString("TrueText");
            String FalseText = text.getString("FalseText");
            
            JSONObject checkpoints = text.getJSONObject("Checkpoints");
            
            ArrayList<CheckpointQuery> cpqObjects = new ArrayList<CheckpointQuery>();
            for(Object checkpointName: checkpoints.keys()) {
                CheckpointQuery cpq = new CheckpointQuery((String) checkpointName, checkpoints.getBoolean((String) checkpointName));
                cpqObjects.add(0, cpq);
            }
            
            println(TrueText, FalseText, cpqObjects);
            
            Text textObject = new Text(TrueText, FalseText, cpqObjects);
            
            textObjects.add(0, textObject);
            
        }
    
    println(textObjects);
    
    //At this point we have hm, which is the hashmap of checkpoints and textObjects, which contains all of the text objects.

    //println(hm);
    }
}
