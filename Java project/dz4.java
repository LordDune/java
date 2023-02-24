import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class dz4 {
    
    public static void main(String[] args) throws IOException {
        ArrayList<String> name1 = new ArrayList<String>();
        ArrayList<String> name2 = new ArrayList<String>();
        ArrayList<String> name3 = new ArrayList<String>();
        ArrayList<Integer> age = new ArrayList<Integer>();
        ArrayList<Boolean> gender = new ArrayList<Boolean>();
        BufferedReader br = new BufferedReader (new FileReader("fio.txt"));
        String str;
        while ((str = br.readLine()) != null){
            fillArrayList(str, name1, name2,name3,age,gender);
        }
        br.close();
        System.out.println("-- Файл 'fio.txt' прочитан. Данные добавлены в Список --");
        
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner scanner = new Scanner(System.in, encoding);
        String s = "";
        while(s != "q"){
            System.out.println("Введите фамилию имя отчество возраст пол (m/f или м/ж) через пробел или наберите 'q' для выхода: ");
            s = scanner.nextLine().toString();
            if (s.equals("q")) break;
            fillArrayList(s, name1, name2, name3, age, gender);
        }
        for (int i = 0; i < name1.size(); i++) {
            showPersons(i, true, name1, name2, name3, age, gender);
        }

        System.out.println("Наберите 'sort' для сортировки списка по возрасту или любой символ для выхода: ");
        s = scanner.nextLine().toString();
        if (s.equals("sort")){
            ArrayList<Integer> ageTemp = new ArrayList<Integer>();        
            for (int i = 0; i < age.size(); i++) {
                ageTemp.add(age.get(i));
            }
            for (int j = 0; j < age.size(); j++) {
                int min = 1000;
                int minI = 0;
                for (int i = 0; i < ageTemp.size(); i++) {
                    if (ageTemp.get(i) < min && ageTemp.get(i) >= 0) {
                        min = ageTemp.get(i);
                        minI = i;
                    }
                }
                showPersons(minI, false, name1, name2, name3, age, gender);
                ageTemp.set(minI, -1);
            }
        }   
    }

    static void showPersons(int i, Boolean shortStr, ArrayList<String> name1,
                                                     ArrayList<String> name2,
                                                     ArrayList<String> name3,
                                                     ArrayList<Integer> age,
                                                     ArrayList<Boolean> gender){
            StringBuilder g = new StringBuilder();
            if (gender.get(i) == true) g.append("m");
            else g.append("f");
            StringBuilder str = new StringBuilder();  
            if (shortStr == false){
                str.append(name1.get(i)+ " ").append(name2.get(i)+ " ").append(name3.get(i)+ " ").append(age.get(i) + " ").append(g);
                System.out.println(str);
            }
            else {
                str.append(name1.get(i)+ " ").append(name2.get(i).charAt(0)+ ".").append(name3.get(i).charAt(0)+ ". ").append(age.get(i) + " ").append(g);
                System.out.println(str);
            }
    }
    static void fillArrayList(String str, ArrayList<String> name1,
                                ArrayList<String> name2,
                                ArrayList<String> name3,
                                ArrayList<Integer> age,
                                ArrayList<Boolean> gender){
        String[] person = str.split(" ");
        name1.add(person[0]);
        name2.add(person[1]);
        name3.add(person[2]);
        age.add(Integer.parseInt(person[3]));
        gender.add(person[4].charAt(0) == 'm' || person[4].charAt(0) == 'м');
    }   
}
