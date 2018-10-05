public class Pair<T1, T2> {
    public final T1 left;
    public final T2 right;

    protected Pair(T1 left, T2 right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public final int hashCode() {
        int hashCode = 31 + (left == null ? 0 : left.hashCode());
        return 31 * hashCode + (right == null ? 0 : right.hashCode());
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair that = (Pair) o;
        // handles nulls properly
        boolean res1 = (left == null ? that.left == null : left.equals(that.left));
        boolean res2 = (right == null ? that.right == null : right.equals(that.right));
        return res1 && res2;
    }

    @Override
    public String toString() {
        return "(" + left + "," + right + ")";
    }

    //For functional interfaces
    public T1 left() {
        return left;
    }

    //For functional interfaces
    public T2 right() {
        return right;
    }

    public static <X, Y> Pair<X, Y> create(X x, Y y) {
        return new Pair<X, Y>(x, y);
    }
}