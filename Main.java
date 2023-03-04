import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  extends JFrame implements ActionListener {

    JButton stack,queue;
    public Main(){
        stack=new JButton("STACK");
        queue=new JButton("QUEUE");

        setLayout(null);
        setSize(1000,1000);
        setLocation(500,500);
        setVisible(true);


        stack.setBounds(200,400,150,50);
        queue.setBounds(400,400,150,50);

        add(stack);
        add(queue);

        stack.addActionListener(this);
        queue.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show();
    }
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==stack){
            new StackDemo();
        }
        if(e.getSource()==queue){
            new QueueDemo();
        }
    }
}