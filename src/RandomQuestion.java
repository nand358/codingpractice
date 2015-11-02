/**
 * Created by anatarajan on 10/20/15.
 */
public class RandomQuestion {

    public static void main(String[] args) {
        int[] myArr = {1,2,3,4,5,6,7};
        int number = 8;
        long t0 = System.currentTimeMillis();
        for(int i : myArr) {
            for (int j : myArr) {
                if(i + j == number) {
                    System.out.println("[" + i + "," + j + "]");
                }
            }
        }
        long deltaT = System.currentTimeMillis() - t0;
        System.out.println(deltaT);


    }
}
