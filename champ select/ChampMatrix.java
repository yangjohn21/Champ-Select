import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChampMatrix {
    // matrix values 1-10

    // this should return a Map where each relevant champ is a key whose values are
    // energy and brain usage
    private Map<String, Champ> finalChampMap;
    private Map<String, Champ> completeChampMap;

    public ChampMatrix(Set<String> champPool) {
        this.completeChampMap = createCompleteChampMatrix();
        this.finalChampMap = getTailoredChamps(champPool);
    }

    // this is where the values for each champ are stored
    // can be replaced by a json file where the method reads from json file
    private static Map<String,Champ> createCompleteChampMatrix(){
        Map<String,Champ> completeChampMap = new HashMap<>();     
        //later can add tags for each champ
        completeChampMap.put("aatrox",new Champ(60,60));
        completeChampMap.put("ahri",new Champ(62,45));
        completeChampMap.put("akshan",new Champ(47,34));
        completeChampMap.put("alistar",new Champ(50,55));
        completeChampMap.put("amumu",new Champ(25,54));
        completeChampMap.put("anivia",new Champ(35,63));
        completeChampMap.put("annie",new Champ(15,25));
        completeChampMap.put("aphelios",new Champ(65,73));
        completeChampMap.put("ashe",new Champ(46,45));
        completeChampMap.put("aurelion sol",new Champ(40,55));
        completeChampMap.put("azir",new Champ(70,85));
        completeChampMap.put("bard",new Champ(34,68));
        completeChampMap.put("blitzcrank",new Champ(45,50));
        completeChampMap.put("brand",new Champ(30,28));
        completeChampMap.put("braum",new Champ(45,56));
        completeChampMap.put("caitlyn",new Champ(67,45));       
        completeChampMap.put("cassiopeia",new Champ(62,56));
        completeChampMap.put("chogath",new Champ(32,46));
        completeChampMap.put("corki",new Champ(62,43));
        completeChampMap.put("darius",new Champ(54,41));
        completeChampMap.put("diana",new Champ(61,43));
        completeChampMap.put("drmundo",new Champ(34,42));
        completeChampMap.put("draven",new Champ(62,41));
        completeChampMap.put("ekko",new Champ(68,52));
        completeChampMap.put("elise",new Champ(46,68));
        completeChampMap.put("evelynn",new Champ(69,86));
        completeChampMap.put("ezreal",new Champ(69,48));
        completeChampMap.put("fiddlesticks",new Champ(45,73));
        completeChampMap.put("fizz",new Champ(63,40));
        completeChampMap.put("galio",new Champ(39,51));
        completeChampMap.put("gangplank",new Champ(62,75));
        completeChampMap.put("gnar",new Champ(62,39));
        completeChampMap.put("gragas",new Champ(43,53));
        completeChampMap.put("graves",new Champ(57,38));
        /*
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        completeChampMap.put("",new Champ(,));
        */
        completeChampMap.put("tryndamere",new Champ(70,30));
        completeChampMap.put("garen",new Champ(30,10));
        completeChampMap.put("fiora",new Champ(80,60));
        completeChampMap.put("rammus",new Champ(30,100));   
        completeChampMap.put("akali",new Champ(80,40)); 
        completeChampMap.put("sion",new Champ(30,30));  
        completeChampMap.put("camille",new Champ(60,70));     
        return completeChampMap;
    }

    private Map<String, Champ> getTailoredChamps(Set<String> champPool) {
        Map<String, Champ> tailoredMap = new HashMap<>();
        for (String champName : champPool) {
            tailoredMap.put(champName, completeChampMap.get(champName));
        }
        return tailoredMap;
    }

    public Map<String, Champ> getResult() {
        return this.finalChampMap;
    }
    public static Set<String> getAllChampSet(){
        return createCompleteChampMatrix().keySet();
    }
}
