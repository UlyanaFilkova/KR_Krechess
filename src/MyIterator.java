public interface MyIterator<K,V> {
    public Pair<K,V> first();
    public void next();
    public boolean isDone();
    public Pair<K,V> currentItem();
}
