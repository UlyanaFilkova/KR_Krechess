import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class View extends JFrame implements ActionListener{
    private final JButton getButton= new JButton("  get  ");
    private final JButton putButton= new JButton("  put  ");
    private final JButton putAllButton = new JButton("putAll");
    private final JButton cleanButton = new JButton("clean");
    private final JButton countButton = new JButton("count");
    private final JButton exitButton = new JButton(" exit  ");
    MyMap<Integer, String> map = new MyMap<>();
    DefaultListModel listModel = map.getListModel();
    JList list = new JList(listModel);
    Controller controller;
    MyMap<Integer,String> model;

    public View(String title, Controller controller, MyMap<Integer,String> model) {
        super(title);

        this.controller = controller;
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getButton){
            controller.PressGet();
        } else if(e.getSource()==putButton) {
            try {
                controller.PressPut();
            } catch (IOException ex) {
                throw new RuntimeException("Some problem with 'put' in MyMap");
            }
        } else if(e.getSource() == putAllButton) {
            try {
                controller.PressPutAll();
            } catch (IOException ex) {
                throw new RuntimeException("Some problem with 'putAll' in MyMap");
            }
        } else if(e.getSource() == cleanButton) {
            controller.PressClean();
        } else if (e.getSource() == countButton) {
            controller.PressCount();
        } else if (e.getSource() == exitButton) {
            controller.PressExit();
        }
    }
    public void createView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        setLayout(new BorderLayout());
        Box hBox = Box.createHorizontalBox();
        Box vBox = Box.createVerticalBox();

        getButton.addActionListener(this);
        putButton.addActionListener(this);
        putAllButton.addActionListener(this);
        cleanButton.addActionListener(this);
        countButton.addActionListener(this);
        exitButton.addActionListener(this);


        JLabel label = new JLabel("MyMap Structure");
        vBox.add(label);
        vBox.add(getButton);
        vBox.add(putButton);
        vBox.add(putAllButton);
        vBox.add(cleanButton);
        vBox.add(countButton);
        vBox.add(exitButton);

        hBox.add(vBox);
        panel.add(hBox);
        add(list, BorderLayout.EAST);
        add(new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
                BorderLayout.EAST);
        add(panel);
        pack();
        setVisible(true);
    }
}
