package library;

/**
 * Created by anatarajan on 10/26/15.
 */
public class RecursiveSum {
    public int sum(int n) {
        if(n == 1) {
            return 1;
        } else {
            System.out.println("Calculating sum for " + (n - 1) );
            return (sum(n-1) + n);
        }
    }

    public static void main(String[] args) {
        RecursiveSum sumobj = new RecursiveSum();
        System.out.println(sumobj.sum(10));
    }

}
