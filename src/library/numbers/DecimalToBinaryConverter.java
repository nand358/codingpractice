package library.numbers;

/**
 * Created by anatarajan on 10/30/15.
 */
public class DecimalToBinaryConverter {

    public static void binary(int num) {

        int remainder = 0;
        if(num <= 1) {
            System.out.print(num);
            return;
        }

        remainder = num % 2;
        binary(num >> 1);

        System.out.print(remainder);

    }

    private static void decimal(int num) {

        int binary = num;
        int power = 0;
        int decimal = 0;

        while(binary != 0) {
            int lastDigit = binary % 10;
            decimal += (lastDigit * (Math.pow(2,power)));
            power++;
            binary = binary/10;
        }

        System.out.println(decimal);

    }



    public static void replaceBinary(int num1, int num2) {

    }

    public static void main(String[] args) {
        binary(5); System.out.println();
        binary(0); System.out.println();
        binary(10); System.out.println();
        binary(32); System.out.println();
        binary(Integer.MAX_VALUE);

        decimal(100);
        decimal(10);
        decimal(101);
        decimal(1111100000);
    }


}
