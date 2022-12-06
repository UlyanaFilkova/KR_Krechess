import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MyMap <K,V extends Comparable> implements Iterable<K,V>,Element<K,V>{
    protected ArrayList<Pair<K,V>> map;

    public MyMap(){
        map = new ArrayList<>();
    }
    public MyMap(ArrayList<Pair<K,V>> map) throws IOException{
        if (map == null) throw new IOException("Warring: Your MyMap == null");
        this.map = map;
    }
    public Integer size(){
        return this.map.size();
    }

    public boolean isEmpty(){
        return this.map.isEmpty();
    }

    public void clear(){
        map.clear();
    }

    public boolean equals(MyMap<K,V> tempMyMap) {
        boolean flag = true;
        if(this.size() != tempMyMap.size()){
            return false;
        }
        for (int i = 0; i < tempMyMap.map.size();i++){
            if(!map.get(i).equals(tempMyMap.map.get(i))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public String toString(){
        return map.toString();
    }

    public DefaultListModel<V> getListModel(){
        DefaultListModel<V> temp = new DefaultListModel<V>();
        for (var tempMapElement : map){
            temp.addElement(tempMapElement.getValue());
        }

        return temp;
    }
    public V get(K key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) != null) {
                if (map.get(i).getKey().equals(key)) {
                    return map.get(i).getValue();
                }
            }
        }
        return null;
    }
    public void put(K key, V value) throws IOException {
        boolean insert = true;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getKey().equals(key)) {
                map.get(i).setValue(value);
                insert = false;
            }
        }
        if (insert) {
            map.add(new Pair(key,value));
            this.map.sort((x , y) -> x.hashCode() - y.hashCode());
        }
    }
    public void putAll(ArrayList<Pair<K, V>> list) throws IOException {
        if(list.size() != 0){
            for(int i = 0; i < list.size(); i++){
                put(list.get(i).getKey(),list.get(i).getValue());
            }
        }
    }

    @Override
    public MyIterator<K, V> getIterator() {
        return new MapIterator<K,V>(this);
    }

    @Override
    public void accept(Visitor<K, V> visitor) {
        visitor.visit(this);
    }
}
