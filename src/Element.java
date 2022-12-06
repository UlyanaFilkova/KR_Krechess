public interface Element<K,V extends Comparable> {
    public void accept(Visitor<K,V> visitor);
}
