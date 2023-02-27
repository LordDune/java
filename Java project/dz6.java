import java.util.ArrayList;
import java.util.HashMap;

public class dz6 {
    public static void main(String[] args) {
        Myset set = new Myset();
        set.add(44);
        set.add(55);
        set.add(66);
        set.add(77);
        set.add(88);
        set.add(99);
        System.out.println(set);   // [66, 99, 55, 88, 44, 77]
        System.out.println(set.contains(44));   // true
        System.out.println(set.get(4));    // 44
        System.out.println(set.getArrayList()); // [66, 99, 55, 88, 44, 77]
        System.out.println(set.headSet(55));    // [66, 99, 55]
        System.out.println(set.tailSet(55));     // [55, 88, 44, 77]
        System.out.println(set.subSet(55,44));   //[55, 88, 44]
    }
}

class Myset {
    private HashMap<Integer, Object> values = new HashMap();
    private static final Object X = new Object();

     void add(int data){
         values.put(data, X);
     }

     public String toString() {
         return values.keySet().toString();
     }

     Boolean contains(int data) {
         return values.containsKey(data);
     }
void clear() {
         values.clear();
     }

     void remove(int data) {
         values.remove(data);
     }

     int size() {
         return values.size();
     }

     int get(int ind) {
         return (int) values.keySet().toArray()[ind];
     }

     ArrayList getArrayList() {

         ArrayList<Integer> res = new ArrayList<>();
         values.forEach((k, v) -> res.add(k));

         return res;
     }

     Myset headSet(int data){
        Myset res = new Myset();
        for (int el: values.keySet()) {
            res.add(el);
            if (data == el)
                break;
        }
        return res;
    }

    Myset tailSet(int data){
        boolean ad = false;
        Myset res = new Myset();
        for (int el: values.keySet()) {
            if (data == el) 
                ad = true;
            if (ad) {
                res.add(el);}
        }
        return res;
    }

 Myset subSet (int key1, int key2){
        Myset res = new Myset();
        Boolean ad = false;
        for (int el: values.keySet()) {
            if ((el == key1 || el == key2) && ad == false){
                ad = true;
                res.add(el);
                continue;
            }
            if ((el == key1 || el == key2) && ad){
                res.add(el);
                break;}
            else if (ad) res.add(el);
        }
        return res;
    }
}