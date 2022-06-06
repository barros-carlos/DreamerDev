import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cabinet extends GameObject implements ActionListener {

    Handler handler;
    Player player;
    Vars vars;
    JFrame s;
    JTextArea lblCode;
    String code, state = "True";
    JButton btnCabinet, btnCabinetT, btnCabinetF;
    public Cabinet(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
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
            g.drawString("E",   (int) (x-25+width*0.60), y+40);
        } 
        //g.setColor(new Color(200, 50, 220));
        //g.fillRect(x, y, width, height);
    }
    @Override
    public void actionPlayer() {
        if(vars.getCurrentLevel() == 4){
            code = "def ArmarioEscola():\n\tclosed = " + state;
            
            s = new JFrame("Armario da Escola");
            s.setSize(550,400);
            s.setLayout(null);
            s.setResizable(false);
            s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            lblCode = new JTextArea("");
            btnCabinet = new JButton("Armario");
            btnCabinetT = new JButton("True");
            btnCabinetF = new JButton("False");

            
            lblCode.setBounds(180,10,450,100);
            btnCabinet.setBounds(10,10,160,50);
            btnCabinetT.setBounds(20,60,150,50);
            btnCabinetF.setBounds(20,110,150,50);

            btnCabinet.addActionListener(this);
            btnCabinetT.addActionListener(this);
            btnCabinetF.addActionListener(this);
            
            s.add(lblCode);
            s.add(btnCabinet);
            s.add(btnCabinetT);
            s.add(btnCabinetF);
    
            btnCabinetT.setEnabled(false);
            btnCabinetF.setEnabled(false);
            lblCode.setEditable(false);

            s.setLocationRelativeTo(null);
            s.setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Armario")){
            lblCode.setText(code);
            btnCabinet.setEnabled(false);
            btnCabinetF.setEnabled(true);
            btnCabinetT.setEnabled(true);
        }
        else if(s.equals("True")){
            state = "True";
            code = "def ArmarioEscola():\n\tclosed = " + state;
            lblCode.setText(code);
            vars.setLvl4State(true);
        }
        else if(s.equals("False")){
            state = "False";
            code = "def ArmarioEscola():\n\tclosed = " + state;
            lblCode.setText(code);
            vars.setLvl4State(false);
        }
    }
}