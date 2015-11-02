import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: anatarajan
 * Date: 5/29/15
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestComparator {

    public class BidRateAmountComparator implements Comparator<PriceElement> {
        private final Comparator<PriceElement> c1 = new BidRateComparator();
        private final ProviderComparator c3 = new ProviderComparator();

        @Override
        public int compare( PriceElement pe1, PriceElement pe2 ) {
            int result = c1.compare( pe1,pe2 );

            if( result == 0 ){
                result = c3.compare( pe1,pe2 );
            }
            return result;
        }

        public ProviderComparator getProviderComparator() {
            return c3;
        }
    }

    public class BidRateComparator implements Comparator<PriceElement> {
        @Override
        public int compare( PriceElement pe1, PriceElement pe2 ) {
            if( pe1.getRate() > pe2.getRate() ){
                return -1;
            }
            else if( pe1.getRate() < pe2.getRate() ){
                return 1;
            }
            return 0;
        }
    }

    public class ProviderComparator implements Comparator<PriceElement> {
        @Override
        public int compare( PriceElement pe1, PriceElement pe2 ) {
            if( pe1.getTier() < pe2.getTier() ){
                return -1;
            }
            else{
                return 1;
            }        }
    }

    public class PriceElement {
        double rate;

        public int getTier() {
            return tier;
        }

        public void setTier(int tier) {
            this.tier = tier;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        int tier;


        public PriceElement(double rate, int tier) {
            this.rate = rate;
            this.tier = tier;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(50);
            sb.append(tier).append(' ').append(rate);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        TestComparator comp = new TestComparator();
        comp.testComparator();
    }

    public void testComparator()  {
        // {"o":3000000.0,"n":"CZBK","p":1.09418,"t":2,"s":1432838529166},
        // {"o":2000000.0,"n":"CZBK","p":1.09418,"t":1,"s":1432838529166},
        // {"o":1000000.0,"n":"CZBK","p":1.09418,"t":0,"s":1432838529166},
        // {"o":5000000.0,"n":"CZBK","p":1.09417,"t":3,"s":1432838529166},
        BidRateAmountComparator bidRateAmountComparator = new BidRateAmountComparator();
        PriceElement pe1 = new PriceElement(1.09418, 2);
        PriceElement pe2 = new PriceElement(1.09418, 1);
        PriceElement pe3 = new PriceElement(1.09418, 0);
        PriceElement pe4 = new PriceElement(1.09417, 3);


        for(int i = 0 ; i < 100 ; i++) {
            ArrayList<PriceElement> list = new ArrayList<PriceElement>(4);
            list.add(pe1);
            list.add(pe2);
            list.add(pe3);
            list.add(pe4);

            Collections.sort(list, bidRateAmountComparator);

            System.out.print(list);
        }



    }
}
