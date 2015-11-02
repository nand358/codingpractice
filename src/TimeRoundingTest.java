/**
 * Created with IntelliJ IDEA.
 * User: anatarajan
 * Date: 4/23/15
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeRoundingTest {
    private int streamCategoryFlags;

    public static void main(String[] args) {
        TimeRoundingTest test = new TimeRoundingTest();

        test.enableFlagForStreamCategory(StreamCategory.B);
        System.out.println(test.getStreamCategoryFlags());

        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.ENABLE_DISABLE_FLAG));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.B.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.X.streamCategoryFlag));

        test.disableFlagForStreamCategory(StreamCategory.B);
        System.out.println(test.getStreamCategoryFlags());
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.ENABLE_DISABLE_FLAG));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.B.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.X.streamCategoryFlag));


        System.out.println("------------------");

        test.enableFlagForStreamCategory(StreamCategory.E);
        System.out.println(test.getStreamCategoryFlags());
        test.enableFlagForStreamCategory(StreamCategory.V);
        System.out.println(test.getStreamCategoryFlags());

        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.ENABLE_DISABLE_FLAG));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.B.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.X.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.E.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.V.streamCategoryFlag));

        System.out.println("------------------");


        test.disableFlagForStreamCategory(StreamCategory.E);
        System.out.println(test.getStreamCategoryFlags());

        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.ENABLE_DISABLE_FLAG));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.B.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.X.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.E.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.V.streamCategoryFlag));

        System.out.println("------------------");

        test.disableFlagForStreamCategory(StreamCategory.V);
        System.out.println(test.getStreamCategoryFlags());

        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.ENABLE_DISABLE_FLAG));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.B.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.X.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.E.streamCategoryFlag));
        System.out.println(test.isStreamCategoryFlagEnabled(StreamCategory.V.streamCategoryFlag));

        System.out.println("------------------");
        test.enableFlagForStreamCategory(StreamCategory.E);
        System.out.println(test.getStreamCategoryFlags());
        test.enableFlagForStreamCategory(StreamCategory.E);
        System.out.println(test.getStreamCategoryFlags());



    }

    public void enableFlagForStreamCategory(StreamCategory strmCategory) {
        streamCategoryFlags = streamCategoryFlags | StreamCategory.ENABLE_DISABLE_FLAG;
        streamCategoryFlags = streamCategoryFlags | strmCategory.getStreamCategoryFlag();
    }

    public void disableFlagForStreamCategory(StreamCategory strmCategory) {
        streamCategoryFlags = streamCategoryFlags & ~strmCategory.getStreamCategoryFlag();
        if(streamCategoryFlags == StreamCategory.ENABLE_DISABLE_FLAG) {
            streamCategoryFlags = streamCategoryFlags & ~StreamCategory.ENABLE_DISABLE_FLAG;
        }
    }

    public boolean isStreamCategoryFlagEnabled( int flag ) {
        return ( streamCategoryFlags & flag ) == flag;
    }

    public int getStreamCategoryFlags() {
        return streamCategoryFlags;
    }

    public enum StreamCategory {
        V("V", "Category V", 100, 0x2),
        A("A", "Category A", 95, 0x4),
        B("B", "Category B", 90, 0x8),
        C("C", "Category C", 85, 0x10),
        D("D", "Category D", 80, 0x20),
        E("E", "Category E", 75, 0x40),
        F("F", "Category F", 70, 0x80),
        G("G", "Category G", 65, 0x100),
        H("H", "Category H", 60, 0x200),
        I("I", "Category I", 55, 0x400),
        J("J", "Category J", 50, 0x800),
        K("K", "Category K", 45, 0x1000),
        L("L", "Category L", 40, 0x2000),
        M("M", "Category M", 35, 0x4000),
        N("N", "Category N", 30, 0x8000),
        O("O", "Category O", 25, 0x10000),
        P("P", "Category P", 20, 0x20000),
        Q("Q", "Category Q", 15, 0x40000),
        R("R", "Category R", 10, 0x80000),
        S("S", "Category S", 5, 0x100000),
        X("X", "Direct LP", 0, 0x200000);

        public static int ENABLE_DISABLE_FLAG = 0x1;

        private final String shortName;
        private final String description;
        private final int priority;
        private final int streamCategoryFlag;

        private static final StreamCategory[] streamCategories = {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, V, X };

        private StreamCategory(String shortName, String description, int priority, int streamCategoryFlag) {
            this.shortName = shortName;
            this.description = description;
            this.priority = priority;
            this.streamCategoryFlag = streamCategoryFlag;
        }

        public String getShortName() {
            return shortName;
        }

        public String getDescription() {
            return description;
        }

        public int getPriority() {
            return priority;
        }

        public int getStreamCategoryFlag() {
            return streamCategoryFlag;
        }

        public static StreamCategory[] streamCategories() { return streamCategories; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("StreamCategory{");
            sb.append("shortName='").append(shortName).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", priority=").append(priority).append('\'');
            sb.append(", streamCategoryFlag=").append(streamCategoryFlag);
            sb.append('}');
            return sb.toString();
        }
    }
}
