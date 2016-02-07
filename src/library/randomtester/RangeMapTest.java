package library.randomtester;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anatarajan on 10/21/15.
 */
public class RangeMapTest {

    RangeMap rangeMap = new RangeMap();

    public void add(double lower, double upper, Object value) {
        rangeMap.put(lower, upper, value);
    }

    public String getValue(double point) {
        Object value = rangeMap.getValue(point);
        if(value == null) {
            value = "Not Found in Map";
        }
        return (String) value;
    }

    public static void main(String[] args) {
        RangeMapTest test = new RangeMapTest();
        test.add(0, 1000000, "A,B,C,D");
        test.add(3000000, 5000000, "A,B,C");
        test.add(5000000, 8000000, "A,B");
        test.add(10000000, 20000000, "A");

        System.out.println(test.getValue(500000));
        System.out.println(test.getValue(5000000));
        System.out.println(test.getValue(9000000));
        System.out.println(test.getValue(30000000));

    }



    public class RangeMap {
        private final List<RangeEntry> entries = new ArrayList<RangeEntry>();

        public void put(double lower, double upper, Object mappedValue) {
            entries.add(new RangeEntry(lower, upper, mappedValue));
        }
        public Object getValue(double key) {
            for (RangeEntry entry : entries) {
                if (entry.matches(key))
                    return entry.getValue();
            }
            return null;
        }
    }

    static class RangeEntry<L, U, V> {
        private final double lower;
        private final double upper;
        private final Object value;

        public RangeEntry(double lower, double upper, Object mappedValue) {
            this.lower = lower;
            this.upper = upper;
            this.value = mappedValue;
        }
        //strict condition on upper bound - [a,b)
        public boolean matches(double value) {
            return value >= lower && value < upper;
        }
        public Object getValue() { return value; }
    }

}
