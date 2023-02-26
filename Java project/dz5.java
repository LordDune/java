import java.util.HashMap;

public class dz5 {
    public static void main(String[] args) {
        
        HashMap<String,String> hm = new HashMap<>();
        hm.put("1", "один");
        hm.put("2", "два");
        hm.put("3", "три");
        hm.put("4", "четыре");
        hm.put("5", "пять");
        hm.put("6", "шесть");

        showMap(hm); // один, два, три, четыре, пять, шесть,

        for (String item: hm.keySet()){
            hm.compute(item, (k, v) -> v + "!");
        }
        showMap(hm); // один!, два!, три!, четыре!, пять!, шесть!,

        HashMap<String,String> hm2 = new HashMap<>();
        hm2.put("1", "dog");
        hm2.put("22", "cat");
        hm2.put("3", "bird");
        hm2.put("44", "cow");
        hm2.put("5", "bear");
        hm2.put("66", "tiger");
    
        for (String item: hm2.keySet()){
            hm2.merge(item, hm.getOrDefault(item, ""), (v1 , v2) -> v2 + v1);
        }
        showMap(hm2); // cat, cow, tiger, один!dog, три!bird, пять!bear,
    }
    static void showMap(HashMap<String,String> map){
        for (String item: map.values()){
            System.out.print(item + ", ");
        }
        System.out.println("");
    }
}
