import java.util.Scanner;

public class dz2 {

    public static void main(String[] args) {

        System.out.println("1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1-ю строку: ");
        StringBuilder lineOne = new StringBuilder(scanner.nextLine());

        System.out.print("Введите 2-ю строку: ");
        StringBuilder lineTwo = new StringBuilder(scanner.nextLine());

        if (lineOne.toString().contains(lineTwo.toString())) {
            System.out.println("Строка " + lineOne + " содержит подстроку " + lineTwo);

        } else System.out.println("Подстрока не найдена");

        System.out.println("2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).");
        
        System.out.print("Введите 1-ю строку: ");
        lineOne = new StringBuilder(scanner.nextLine());

        System.out.print("Введите 2-ю строку: ");
        lineTwo = new StringBuilder(scanner.nextLine());
        
        if (lineOne.reverse().toString().equals(lineTwo.toString())){

            System.out.println("Строка " + lineOne.reverse() + " является вращением строки " + lineTwo);

        } else System.out.println("Строки не являются вращением друг друга");

        System.out.println("3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.");
        System.out.print("Введите строку: ");
        StringBuilder s = new StringBuilder(scanner.nextLine());
        System.out.println(reverseString(s,0));

        System.out.println("4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 - 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().");
        System.out.print("Введите первое число: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите второе число: ");
        int b = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        result.append(String.format("%d + %d = %d, ", a, b, a + b));
        result.append(String.format("%d - %d = %d, ", a, b, a - b));
        result.append(String.format("%d * %d = %d", a, b, a * b));
        System.out.println(result);
        String s1 = result.toString();

        System.out.println("5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().");
        
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '='){
                result.deleteCharAt(i);
                result.insert(i, "равно");
            }
        }
        System.out.println(result);

        System.out.println("6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().");
        StringBuilder builder = new StringBuilder();
        builder.append(s1);
        System.out.println(builder);
        for (int i = 0; i < result.length(); i++) {
            if (builder.charAt(i) == '='){
                builder.replace(i,i+1, "равно");
            }
        }
        System.out.println(builder);

        System.out.println("7.*Сравнить время выполнения пункта 6 со строкой содержащей 10000 символов '=' средствами String и StringBuilder.");
        
        
        String ss1 = "";
        for (int i = 0; i < 10000; i++) {
            ss1 += "=";
        }
        var start = System.currentTimeMillis();    
        
        ss1 = ss1.replace("=", "равно");
        var stop = System.currentTimeMillis();
        System.out.print("Время выполнения средствами String: ");
        System.out.println(stop - start);
        
        StringBuilder ss2 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            ss2.append("=");
        }
        var start1 = System.currentTimeMillis();

        // ss2.replace(0,ss2.length(), "равно"); //данным способом StringBuilder меняет быстрее, но здесь безусловно все элементы заменяются

        for (int i = 0; i < ss2.length(); i++) {
            if (ss2.charAt(i) == '='){
                ss2.replace(i, i+1, "равно"); // Если заменять только найденный символ, то выполнется дольше, чем String
            }           
        }
        var stop1 = System.currentTimeMillis();
        System.out.print("Время выполнения средствами StringBuilder: "); 
        System.out.println(stop1 - start1);


    }   


    static StringBuilder reverseString(StringBuilder s, int number){
        if (number+2 > s.length()) return s;
        else {
            int num = s.length() - (number + 2);
            s.append(s.charAt(num));
            s.delete(num, num+1);
            return reverseString(s,++number);
        }
    }

}   



