public class MySstableReader {
    private String sstableName;
    private Long size;

    public MySstableReader(String sstableName, Long size) {
        this.sstableName = sstableName;
        this.size = size;
    }

    public String getSstableName() {
        return sstableName;
    }

    public Long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MySstableReader{" + "sstableName='" + sstableName + '\'' + ", size=" + size + '}';
    }
}
