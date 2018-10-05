import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBuckets {
    /*
  * Group files of similar size into buckets.
  */
    public static <T> List<List<T>> getBuckets(Collection<Pair<T, Long>> files, double bucketHigh, double bucketLow,
                    long minSSTableSize)
    {
        // Sort the list in order to get deterministic results during the grouping below
        List<Pair<T, Long>> sortedFiles = new ArrayList<Pair<T, Long>>(files);
        Collections.sort(sortedFiles, new Comparator<Pair<T, Long>>()
        {
            public int compare(Pair<T, Long> p1, Pair<T, Long> p2)
            {
                return p1.right.compareTo(p2.right);
            }
        });

        Map<Long, List<T>> buckets = new HashMap<Long, List<T>>();

        outer:
        for (Pair<T, Long> pair: sortedFiles)
        {
            long size = pair.right;

            // look for a bucket containing similar-sized files:
            // group in the same bucket if it's w/in 50% of the average for this bucket,
            // or this file and the bucket are all considered "small" (less than `minSSTableSize`)
            for (Map.Entry<Long, List<T>> entry : buckets.entrySet())
            {
                List<T> bucket = entry.getValue();
                long oldAverageSize = entry.getKey();
                if ((size > (oldAverageSize * bucketLow) && size < (oldAverageSize * bucketHigh))
                                || (size < minSSTableSize && oldAverageSize < minSSTableSize))
                {
                    // remove and re-add under new new average size
                    buckets.remove(oldAverageSize);
                    long totalSize = bucket.size() * oldAverageSize;
                    long newAverageSize = (totalSize + size) / (bucket.size() + 1);
                    bucket.add(pair.left);
                    buckets.put(newAverageSize, bucket);
                    continue outer;
                }
            }

            // no similar bucket found; put it in a new one
            ArrayList<T> bucket = new ArrayList<T>();
            bucket.add(pair.left);
            buckets.put(size, bucket);
        }

        return new ArrayList<List<T>>(buckets.values());
    }

    public static <T> Map<Long, List<T>> getBucketsMap(Collection<Pair<T, Long>> files, double bucketHigh, double
                    bucketLow,
                    long minSSTableSize)
    {
        // Sort the list in order to get deterministic results during the grouping below
        List<Pair<T, Long>> sortedFiles = new ArrayList<Pair<T, Long>>(files);
        Collections.sort(sortedFiles, new Comparator<Pair<T, Long>>()
        {
            public int compare(Pair<T, Long> p1, Pair<T, Long> p2)
            {
                return p1.right.compareTo(p2.right);
            }
        });

        Map<Long, List<T>> buckets = new HashMap<Long, List<T>>();

        outer:
        for (Pair<T, Long> pair: sortedFiles)
        {
            long size = pair.right;

            System.out.println(pair.left);

            // look for a bucket containing similar-sized files:
            // group in the same bucket if it's w/in 50% of the average for this bucket,
            // or this file and the bucket are all considered "small" (less than `minSSTableSize`)
            for (Map.Entry<Long, List<T>> entry : buckets.entrySet())
            {
                List<T> bucket = entry.getValue();
                long oldAverageSize = entry.getKey();
                if ((size > (oldAverageSize * bucketLow) && size < (oldAverageSize * bucketHigh))
                                || (size < minSSTableSize && oldAverageSize < minSSTableSize))
                {
                    // remove and re-add under new new average size
                    buckets.remove(oldAverageSize);
                    long totalSize = bucket.size() * oldAverageSize;
                    long newAverageSize = (totalSize + size) / (bucket.size() + 1);
                    bucket.add(pair.left);
                    buckets.put(newAverageSize, bucket);
                    continue outer;
                }
            }

            // no similar bucket found; put it in a new one
            ArrayList<T> bucket = new ArrayList<T>();
            bucket.add(pair.left);
            buckets.put(size, bucket);
        }

        return buckets;
    }
}
