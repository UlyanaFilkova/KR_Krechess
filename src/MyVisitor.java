public class MyVisitor<K,V extends Comparable> implements Visitor<K,V>{
    private Integer count = null;
    MyVisitor(){
        count = 0;
    }
    public int getCount(){return count;}
    @Override
    public void visit(MyMap<K,V> map) {
        for (MyIterator<K,V> it = map.getIterator(); !it.isDone(); it.next()){
            count++;
        }
    }
}
