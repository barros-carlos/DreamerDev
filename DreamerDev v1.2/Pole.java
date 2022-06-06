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


public class Pole extends GameObject implements ActionListener {

    Handler handler;
    Player player;
    Vars vars;
    JFrame s;
    JTextArea lblCode;
    String code, state = "True";
    JButton btnPole, btnA, btnB, btnC;
    public Pole(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
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
            g.drawString("E",   (int) (x-25+width*0.75), y+40);
        } 
        //g.setColor(new Color(200, 50, 220));
        //g.fillRect(1050, 420, 25, 200);
    }
    @Override
    public void actionPlayer() {
        if(vars.getCurrentLevel() == 2){
            code = "Qual o resultado do seguinte programa:\n\n"+
            "a = 10\n"+
            
            "print(f\"{a} é um numero alto')\n\n"+
            
            "a)10 é um numero alto  b)a é um numero alto  c)não compila";
            
            s = new JFrame("Semafaro");
            s.setSize(550,400);
            s.setLayout(null);
            s.setResizable(false);
            s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            lblCode = new JTextArea("");
            btnPole = new JButton("Semafaro");
            btnA = new JButton("A");
            btnB = new JButton("B");
            btnC = new JButton("C");

            
            lblCode.setBounds(180,10,450,490);
            btnPole.setBounds(10,10,160,50);
            btnA.setBounds(20,60,150,50);
            btnB.setBounds(20,110,150,50);
            btnC.setBounds(20,160,150,50);

            btnPole.addActionListener(this);
            btnA.addActionListener(this);
            btnB.addActionListener(this);
            btnC.addActionListener(this);
            
            s.add(lblCode);
            s.add(btnPole);
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
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Semafaro")){
            lblCode.setText(code);
            btnPole.setEnabled(false);
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnC.setEnabled(true);
        }
        else if(s.equals("A")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();
            vars.setLvl2State(true);
        }
        else if(s.equals("B")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();
            vars.setLvl2State(true);
        }        
        else if(s.equals("C")){

            vars.setLvl2State(false);
            this.s.dispose();
        }
    }
}