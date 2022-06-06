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


public class Computer extends GameObject implements ActionListener {

    Handler handler;
    Player player;
    Vars vars;
    JFrame s;
    JTextArea lblCode;
    String code, state = "True";
    JButton btnComputador, btnA, btnB, btnC, btnD;

    public Computer(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
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
            code = "Qual o resultado do seguinte programa:\n\n"+
            "import math\n\n"+
            "a = 5\n"+
            "b = 3\n"+
            "acorda = 'acorda acorda acorda'\n\n"+
            "dic = {'a':'A', 'b':'B', ' ': ''}\n"+
            "x = acorda.translate(str.maketrans(dic))\n\n"+
            "if a >= b:\n"+
            "    y = math.pow(a,b) - len(x)\n" +
            "    print(y)\n"+
            "else:\n"+
            "    print('b e maior que a')\n\n"+
            "a)105 b)107 c)b e maior que a d)nao compila";
            
            s = new JFrame("Computador");
            s.setSize(550,400);
            s.setLayout(null);
            s.setResizable(false);
            s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            lblCode = new JTextArea("");
            btnComputador = new JButton("Computador");
            btnA = new JButton("A");
            btnB = new JButton("B");
            btnC = new JButton("C");
            btnD = new JButton("D");

            
            lblCode.setBounds(180,10,450,490);
            btnComputador.setBounds(10,10,160,50);
            btnA.setBounds(20,60,150,50);
            btnB.setBounds(20,110,150,50);
            btnC.setBounds(20,160,150,50);
            btnD.setBounds(20,210,150,50);

            btnComputador.addActionListener(this);
            btnA.addActionListener(this);
            btnB.addActionListener(this);
            btnC.addActionListener(this);
            btnD.addActionListener(this);
            
            s.add(lblCode);
            s.add(btnComputador);
            s.add(btnA);
            s.add(btnB);
            s.add(btnC);
            s.add(btnD);
    
            btnA.setEnabled(false);
            btnB.setEnabled(false);
            btnC.setEnabled(false);
            btnD.setEnabled(false);
            lblCode.setEditable(false);

            s.setLocationRelativeTo(null);
            s.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Computador")){
            lblCode.setText(code);
            btnComputador.setEnabled(false);
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnC.setEnabled(true);
            btnD.setEnabled(true);
        }
        else if(s.equals("A")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();

        }
        else if(s.equals("B")){
            player.StopChronometer();
            vars.setCurrentLevel(6);
            vars.setInitializedScreen(false);
            this.s.dispose();
        }
        else if(s.equals("C")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();

        }
        else if(s.equals("D")){
            JOptionPane.showMessageDialog(null, "Resposta errada");
            player.penaliteTime();

        }
    }
}
