import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueDemo extends JFrame implements ActionListener {
    
    JLabel[] queue;
    JLabel front,rare;
    int x=100,y=150,fx=50,rx=50;
    JTextField input;
    JButton push,pop,reset;
    int f=-1,r=-1;
    public QueueDemo(){
        queue=new JLabel[10];
        input =new JTextField();
        push=new JButton("ENQUE");
        pop=new JButton("DEQUE");
        front=new JLabel("FRONT");
        rare= new JLabel("RARE");
        reset=new JButton("RESET");
        
        setLayout(null);
        setSize(1000,1000);
        setLocation(500,500);
        setVisible(true);


        input.setBounds(x,y+300,300,40);
        push.setBounds(x,y+400,100,40);
        pop.setBounds(x+200,y+400,100,40);
        reset.setBounds(x+100,y+450,100,40);

        front.setBounds(fx,y-50,50,50);
        rare.setBounds(rx,y+150,50,50);
        for(int i=0;i<queue.length;i++){
            queue[i]=new JLabel();
            queue[i].setBounds(x,y,50,150);
            queue[i].setBorder(BorderFactory.createLineBorder(Color.black));
            x+=50;
            add(queue[i]);

        }



        add(input);
        add(push);
        add(pop);
        add(front);
        add(reset);
        add(rare);

        push.addActionListener(this);
        pop.addActionListener(this);
        reset.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show();

    }
    public static void main(String args[]){
        new QueueDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==push){
            addItem();
        }
        if(e.getSource()==pop){

            removeItem();

        }
        if(e.getSource()==reset){
            resetAll();
        }
    }

    public void resetAll(){
        r=f=-1;
        fx=rx=50;
        front.setBounds(fx,y-50,50,50);
        rare.setBounds(rx,y+150,50,50);
        for(int i=0;i< queue.length;i++){
            queue[i].setText("");
        }

    }
    public void addItem(){
        if(f>9){
            JOptionPane.showMessageDialog(this,"Queue Is Full..");
            f=9;
            return;
        }
        else{
            f+=1;
            queue[f].setText(input.getText());
            fx+=50;
            front.setBounds(fx,y-50,100,40);

        }

    }
    public void removeItem(){
        if(r==f||r>9){
            JOptionPane.showMessageDialog(this,"Queue Is Empty");
        }
        else{
            r+=1;
            queue[r].setText("");

            rx+=50;

        }
        rare.setBounds(rx,y+150,100,40);

    }
}
