import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller{
    private MyMap<Integer,String> model;
    private View view;
    ArrayList<Pair<Integer, String>> tempList = new ArrayList<>();

    public Controller(MyMap<Integer,String> model){
        this.model = model;
        this.view = new View("MyMap Structure",this, model);
        view.createView();
    }
    public void PressPut() throws IOException {
        Pair<Integer, String> tempPair = null;
        String result = JOptionPane.showInputDialog(view, "Enter the pair",
                "put", JOptionPane.PLAIN_MESSAGE);
        if (result!= null && !result.equals("")) {
            String[] data = result.split(" ");
            if (data.length == 2) {
                model.put(Integer.parseInt(data[0]), String.valueOf(data[1]));
                view.listModel.clear();
                ShowElements();
            }
        }
    }

    public void PressPutAll() throws IOException {
        Pair<Integer, String> tempPair = null;
        String result = JOptionPane.showInputDialog(view, "Enter the pairs",
                "putAll", JOptionPane.PLAIN_MESSAGE);
        if (result!= null && !result.equals("")) {
            String[] data = result.split(" ");
            for (int i = 0; i < data.length; i++){
                tempList.add(new Pair<>(Integer.parseInt(data[0 + i]),data[1 + i]));
                i++;
            }
            model.putAll(tempList);
            view.listModel.clear();
            ShowElements();
        }
    }
    public void PressGet() {
        String result = JOptionPane.showInputDialog(view, "Enter the key",
                "get", JOptionPane.PLAIN_MESSAGE);
        if (result!= null && !result.equals("")){
            if(model.get(Integer.parseInt(result)) == null){
                JOptionPane.showMessageDialog(view, "There is not this key",
                        "get", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(view, "Your value: " +
                    model.get(Integer.parseInt(result)) , "get", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public void PressClean(){
        model.clear();
        tempList.clear();
        view.listModel.clear();
    }
    public void PressCount(){
        Visitor<Integer,String> visitor = new MyVisitor<>();
        model.accept(visitor);
        JOptionPane.showMessageDialog(view, "Your count: " +
                visitor.getCount(), "get", JOptionPane.PLAIN_MESSAGE);
    }
    public void PressExit(){
        System.exit(0);
    }
    public void ShowElements(){
        for (var it = model.getIterator(); !it.isDone(); it.next()){
            view.listModel.addElement(it.currentItem());
        }
    }
}
