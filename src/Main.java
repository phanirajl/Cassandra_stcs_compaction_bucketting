import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    protected static final long DEFAULT_MIN_SSTABLE_SIZE = 50L;// * 1024L * 1024L;
//    protected static final double DEFAULT_BUCKET_LOW = 0.5;
//    protected static final double DEFAULT_BUCKET_HIGH = 1.5;
    /**
     * 378
     [MySstableReader{sstableName='mc-12562-big-Data.db', size=378}]
     1000
     [MySstableReader{sstableName='mc-12561-big-Data.db', size=900}, MySstableReader{sstableName='mc-12560-big-Data.db', size=1000}, MySstableReader{sstableName='mc-12558-big-Data.db', size=1100}]
     4033
     [MySstableReader{sstableName='mc-12553-big-Data.db', size=3900}, MySstableReader{sstableName='mc-12553-big-Data.db', size=4000}, MySstableReader{sstableName='mc-12548-big-Data.db', size=4200}]
     17350
     [MySstableReader{sstableName='mc-12543-big-Data.db', size=14700}, MySstableReader{sstableName='mc-12521-big-Data.db', size=20000}]
     126800
     [MySstableReader{sstableName='mc-12522-big-Data.db', size=126800}]
     */

    protected static final double DEFAULT_BUCKET_LOW = 0.5;
    protected static final double DEFAULT_BUCKET_HIGH = 1.5;

    /**
     * 844
     [MySstableReader{sstableName='mc-12562-big-Data.db', size=378}, MySstableReader{sstableName='mc-12561-big-Data.db', size=900}, MySstableReader{sstableName='mc-12560-big-Data.db', size=1000}, MySstableReader{sstableName='mc-12558-big-Data.db', size=1100}]
     4033
     [MySstableReader{sstableName='mc-12553-big-Data.db', size=3900}, MySstableReader{sstableName='mc-12553-big-Data.db', size=4000}, MySstableReader{sstableName='mc-12548-big-Data.db', size=4200}]
     17350
     [MySstableReader{sstableName='mc-12543-big-Data.db', size=14700}, MySstableReader{sstableName='mc-12521-big-Data.db', size=20000}]
     126800
     [MySstableReader{sstableName='mc-12522-big-Data.db', size=126800}]
     */

    public static void main(String[] args) {
        ArrayList<Pair<MySstableReader, Long>> sstableLengthPairs = new ArrayList<>();
        /**
         * Give all size in MB.
         */
// node-1
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12522-big-Data.db", 126800L), 126800L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12521-big-Data.db", 20000L), 20000L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12543-big-Data.db", 14700L), 14700L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12548-big-Data.db", 4200L), 4200L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12553-big-Data.db", 4000L), 4000L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12553-big-Data.db", 3900L), 3900L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12558-big-Data.db", 1100L), 1100L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12560-big-Data.db", 1000L), 1000L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12561-big-Data.db", 900L), 900L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12562-big-Data.db", 378L), 378L));

// node-2
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10809-big-Data.db", 20000L), 20000L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10810-big-Data.db", 126800L), 126800L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10832-big-Data.db", 15200L), 15200L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10837-big-Data.db", 4000L), 4000L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10842-big-Data.db", 4100L), 4100L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10847-big-Data.db", 4000L), 4000L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10848-big-Data.db", 900L), 900L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10849-big-Data.db", 1100L), 1100L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10850-big-Data.db", 761L), 761L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-11-big-Data.db", 94300L), 94300L));
//        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12-big-Data.db", 58300L), 58300L));

// node-0
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-1006-big-Data.db", 36400L), 36400L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10139-big-Data.db", 2700L), 2700L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10936-big-Data.db", 126800L), 126800L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10937-big-Data.db", 20000L), 20000L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10958-big-Data.db", 16200L), 16200L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10963-big-Data.db", 4500L), 4500L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10968-big-Data.db", 4400L), 4400L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10973-big-Data.db", 4400L), 4400L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-10974-big-Data.db", 194800L), 194800L));


        Map<Long, List<MySstableReader>> buckets = GetBuckets.getBucketsMap(sstableLengthPairs, DEFAULT_BUCKET_HIGH,
                        DEFAULT_BUCKET_LOW,
                        DEFAULT_MIN_SSTABLE_SIZE);

        //System.out.println(buckets);
        TreeMap<Long, List<MySstableReader>> sortedBuckets = new TreeMap<>(buckets);

        for (Map.Entry<Long, List<MySstableReader>> entry: sortedBuckets.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
