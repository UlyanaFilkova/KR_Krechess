public class MapIterator <K,V extends Comparable> implements MyIterator<K,V> {

    private MyMap<K,V> collection;
    public int index;
    public MapIterator(MyMap<K, V> map) {
        this.collection = map;
        index = 0;
    }

    @Override
    public Pair<K,V> first() {
        if (collection.isEmpty()) return null;
        else return new Pair<>(collection.map.get(0).getKey(),collection.map.get(0).getValue());
    }

    @Override
    public void next() {
        if(index < collection.map.size()){
            index += 1;
        }else{
            throw new ArrayIndexOutOfBoundsException("Error! Out of bounds!");
        }
    }

    @Override
    public boolean isDone() {
        return index == collection.size();
    }

    @Override
    public Pair<K,V> currentItem() {
        return new Pair<>(collection.map.get(index).getKey(),collection.map.get(index).getValue()) ;
    }
}
