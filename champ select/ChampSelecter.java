import java.util.HashMap;
import java.util.Map;

public class ChampSelecter {
    //this should use the champ Matrix and then prompt the user fill out certain values in order to determine which champ to use
    //should have some randomness
    Map<String,Champ> champMap;
    PlayerFeeling player;
    public ChampSelecter(PlayerFeeling player, Map<String,Champ> champMap){
        this.champMap = champMap;
        this.player = player;
    }
    public String getResultChamp(boolean isRandom){
        if(isRandom){
            return getRandomChamp();
        }
        return getChamp();
    }
    private String getChamp(){
        
        double minDistance = Double.MAX_VALUE;
        String result = "";
        for (String champName : champMap.keySet()) {
            Champ curr = champMap.get(champName);
            double currDistance = getDistance(curr);
            if(currDistance<minDistance){
                minDistance = currDistance;
                result = champName;
            }
        }        
        return result;
    }
    private double getDistance(Champ champ){
        double result = 0;
        result+=Math.pow(Math.abs(champ.getEnergy()-player.getEnergy()),.5);
        result+=Math.pow(Math.abs(champ.getBrainUsage()-player.getBrainUsage()),.5);
        return result;
    }
    private String getRandomChamp(){
        
        String result = "";
        Map<Double,String> weightedChampMap = new HashMap<>();
        Double currWeight = 0.0;
        //it is supposed to be that champion if the random weight is greater than that champ
        //and that champ is closest to that random weight
        for (String champName : champMap.keySet()) {
            Champ curr = champMap.get(champName);
            //some formula for determining probability weight
            double probWeight = 10*(10*Champ.getPropAmt() - getDistance(curr));
            //scuffed way of assigning champs a spot on the random spinner
            currWeight+=Math.pow(probWeight,5);
            weightedChampMap.put(currWeight,champName);
        }
        //spinning
        double randomWeight = Math.random()*currWeight;
        double minDistance = Double.MAX_VALUE;

        for (Double curr : weightedChampMap.keySet()) {
            if(curr>randomWeight){
                if(curr-randomWeight<minDistance){
                    minDistance = curr-randomWeight;
                    result = weightedChampMap.get(curr);
                }
            }
        }
        return result;
    }
}
