import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackDemo extends JFrame implements ActionListener {
    JLabel[] stack;
    JLabel top;
    JTextField input;
    JButton push,pop,reset;
    int i=-1,topy=750,x,y;
    public StackDemo(){

        stack =new JLabel[10];
        input = new JTextField();
        top = new JLabel(" <= TOP");
        push = new JButton("PUSH");
        pop = new JButton("POP");
        reset= new JButton("RESET");

         x=50 ;y=700;

        setLayout(null);
        setSize(1000,1000);
        setLocation(500,500);
        setVisible(true);


        input.setBounds(x+400,y-400,200,40);
        push.setBounds(x+400,y-200,100,40);
        pop.setBounds(x+600,y-200,100,40);
        reset.setBounds(x+500,y-150,100,40);
        top.setBounds(x+160,topy,100,40);
        for(int i=0;i<stack.length;i++){
            stack[i]=new JLabel();
            stack[i].setBounds(x,y,150,50);
            stack[i].setBorder(BorderFactory.createLineBorder(Color.black));
            y-=50;
            add(stack[i]);

        }

        add(input);
        add(push);
        add(pop);
        add(top);
        add(reset);


        push.addActionListener(this);
        pop.addActionListener(this);
        reset.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show();
    }
    public static void main(String args[]){
        new StackDemo();
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

    public void addItem(){

        if(i>9){
            JOptionPane.showMessageDialog(this,"Stack is Full");
            i=9;
           return;
        }
        else{
            i+=1;
            stack[i].setText(input.getText());
            topy-=50;
            top.setBounds(x+160,topy,100,40);

        }


    }

    public void removeItem(){
        if(i<0){
            JOptionPane.showMessageDialog(this,"Stack Is Empty");
            topy=750;
        }
        else{

            stack[i].setText("");i-=1;

            topy+=50;

        }
        top.setBounds(x+160,topy,100,40);
    }
    public void resetAll(){
        i=-1;
        topy=750;
        top.setBounds(x+160,topy,100,40);
        for(int i=0;i<stack.length;i++){
            stack[i].setText("");
        }

    }
}
