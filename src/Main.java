import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    protected static final long DEFAULT_MIN_SSTABLE_SIZE = 50L;// * 1024L * 1024L;
    protected static final double DEFAULT_BUCKET_LOW = 0.5;
    protected static final double DEFAULT_BUCKET_HIGH = 1.5;


    public static void main(String[] args) {
        ArrayList<Pair<MySstableReader, Long>> sstableLengthPairs = new ArrayList<>();
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12522-big-Data.db", 126800L), 126800L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12521-big-Data.db", 20000L), 20000L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12543-big-Data.db", 14700L), 14700L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12548-big-Data.db", 4200L), 4200L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12553-big-Data.db", 4000L), 4000L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12553-big-Data.db", 3900L), 3900L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12558-big-Data.db", 1100L), 1100L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12560-big-Data.db", 1000L), 1000L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12561-big-Data.db", 900L), 900L));
        sstableLengthPairs.add(new Pair<>(new MySstableReader("mc-12562-big-Data.db", 378L), 378L));

        Map<Long, List<MySstableReader>> buckets = GetBuckets.getBucketsMap(sstableLengthPairs, DEFAULT_BUCKET_HIGH,
                        DEFAULT_BUCKET_LOW,
                        DEFAULT_MIN_SSTABLE_SIZE);

        System.out.println(buckets);
        TreeMap<Long, List<MySstableReader>> sortedBuckets = new TreeMap<>(buckets);

        for (Map.Entry<Long, List<MySstableReader>> entry: sortedBuckets.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
