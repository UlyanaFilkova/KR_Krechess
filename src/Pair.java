public class Pair<K, V> {
    public K key;
    public V value;
    public Pair(K first, V second) {
        this.key = first;
        this.value = second;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (!key.equals(pair.key)) {return false;}
        return value.equals(pair.value);
    }

    @Override
    public String toString() {
        return "(Key: "+ key + ", Value: " + value + ")";
    }

}
