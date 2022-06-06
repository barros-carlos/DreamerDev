import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BedroomDoor extends GameObject implements ActionListener {

    Handler handler;
    Player player;
    Vars vars;
    JFrame s;
    JTextArea lblCode;
    String code, state;
    JButton btnPorta, btnA, btnB,btnC;

    public BedroomDoor(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
        super(x, y, width, height, id);
        this.player = (Player) gameObject;
        this.vars = vars;
    }



    @Override
    public void tick() {
       
    }

    @Override
    public void render(Graphics g) {

                setInteraction(this.interaction(player));
            if(getInteration()){
                g.setColor(new Color(60, 60, 60));
                g.fillRect(x-25+width/2, y, 50, 50);

                Font font = new Font("Arial", Font.BOLD, 45);
                g.setFont(font);
                g.setColor(new Color(255, 255, 255));
                g.drawString("E",   (int) (x-25+width*0.55), y+40);
            }
        //g.setColor(new Color(200, 50, 220));
        //g.fillRect(x, y, width, height);
        
    }
    @Override
    public void actionPlayer() {
            state = "False";
            code = "Qual o resultado do seguinte programa:\n\n"+
            "a = 25\n"+
            "b = 10\n\n"+
            "if a > b\n"+
            "    c= a*b - 2*a\n"+
            "    print (c)\n"+
            "elif a < b:\n" +
            "    c = b/a + (a*a) + 5.5\n" +
            "    print(c)\n"+
            "else:\n"+
            "    print(a+b)\n\n"+
            "a)108  b)200  c)nao compila";
            
            s = new JFrame("Porta");
            s.setSize(550,400);
            s.setLayout(null);
            s.setResizable(false);
            s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            lblCode = new JTextArea("");
            btnPorta = new JButton("Porta");
            btnA = new JButton("A");
            btnB = new JButton("B");
            btnC = new JButton("C");

            
            lblCode.setBounds(180,10,450,490);
            btnPorta.setBounds(10,10,160,50);
            btnA.setBounds(20,60,150,50);
            btnB.setBounds(20,110,150,50);
            btnC.setBounds(20,160,150,50);

            btnPorta.addActionListener(this);
            btnA.addActionListener(this);
            btnB.addActionListener(this);
            btnC.addActionListener(this);
            
            s.add(lblCode);
            s.add(btnPorta);
            s.add(btnA);
            s.add(btnB);
            s.add(btnC);
    
            btnA.setEnabled(false);
            btnB.setEnabled(false);
            btnC.setEnabled(false);
            lblCode.setEditable(false);

            s.setLocationRelativeTo(null);
            s.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Porta")){
            lblCode.setText(code);
            btnPorta.setEnabled(false);
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnC.setEnabled(true);
        }
        else if(s.equals("A")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();
        }
        else if(s.equals("B")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();
        }
        else if(s.equals("C")){
            vars.setCurrentLevel(2);
            vars.setInitializedScreen(false);
            this.s.dispose();
        }
    }
}
