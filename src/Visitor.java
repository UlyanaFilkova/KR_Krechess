public interface Visitor<K,V extends Comparable> {
    public void visit(MyMap<K,V> map);
    public int getCount();
}
