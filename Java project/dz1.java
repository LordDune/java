import java.util.Random;

public class dz1 {
    static int i = 0;
    static int n = 0;
    static int maxRandom = 2000;
    static int minValue = Short.MIN_VALUE;
    static int maxValue = Short.MAX_VALUE;

    public static void main(String[] args) {
        i = new Random().nextInt(maxRandom);
        System.out.println(String.format("i = %s", i));

        String binary = Integer.toBinaryString(i);
        System.out.println(String.format("Число %s в двоичном представлении: %s", i, binary));

        n = binary.length() - 1;
        System.out.println(String.format("Номер старшего значащего бита числа %s: %s", i, n));

        int numbers = SizeArray(i, maxValue, n, "multiple");
        System.out.println(String.format("Количество кратных %s элементов на диапазоне от %s до %s: %s", n, i, maxValue, numbers));
       
        int[] m1 = new int[numbers];
        FillArray(i, maxValue, n, "multiple", m1);

        numbers = SizeArray(minValue, i, n, "non-multiple");
        System.out.println(String.format("Количество некратных %s элементов на диапазоне от %s до %s: %s", n, minValue, i, numbers));
        
        int[] m2 = new int[numbers];
        FillArray(minValue, i, n, "non-multiple", m2);
        
    }

    static int SizeArray(int min, int max, int quot, String mode){
        int numbers = 0;
        for (int j = min; j < max; j++)
        {
            if (mode == "multiple") if (j % n == 0) numbers++;

            if (mode == "non-multiple") if (j % n != 0) numbers++;
        }
        return numbers;
    }

    static void FillArray(int min, int max, int quot, String mode, int[] array){
        for (int j = min, num = 0; j < max; j++)
        {
            if (mode == "multiple") if (j % n == 0){
                array[num] = j;
                num++;
            };

            if (mode == "non-multiple") if (j % n != 0){
                array[num] = j;
                num++;
            }                
        }
    }
}
