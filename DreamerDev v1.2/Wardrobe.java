import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Wardrobe extends GameObject implements ActionListener{

    Handler handler;
    Player player;
    Vars vars;
    JFrame s;
    JTextArea lblCode;
    String code;
    JButton btnRoupa, btnRoupa1, btnRoupa2, btnRoupa3;

    public Wardrobe(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
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
        
        String roupa = vars.getClothes() == 1 ? "\"blusaMangaPreta\"": vars.getClothes() == 2? "\"blusaMangaBranca\"" : "\"Pijama\"";
        code = "def Clothes():\n\tclothes = " + roupa;

        s = new JFrame("Armario");
        s.setSize(550,400);
        s.setLayout(null);
        s.setResizable(false);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblCode = new JTextArea("");
        btnRoupa = new JButton("Roupa");
        btnRoupa1 = new JButton("blusaMangaPreta");
        btnRoupa2 = new JButton("blusaMangaBranca");
        btnRoupa3 = new JButton("pijama");
        
        lblCode.setBounds(180,10,450,100);
        btnRoupa.setBounds(10,10,160,50);
        btnRoupa1.setBounds(20,60,150,50);
        btnRoupa2.setBounds(20,110,150,50);
        btnRoupa3.setBounds(20,160,150,50);

        
        btnRoupa.addActionListener(this);
        btnRoupa1.addActionListener(this);
        btnRoupa2.addActionListener(this);
        btnRoupa3.addActionListener(this);
        
        s.add(lblCode);
        s.add(btnRoupa);
        s.add(btnRoupa1);
        s.add(btnRoupa2);
        s.add(btnRoupa3);

        btnRoupa1.setEnabled(false);
        btnRoupa2.setEnabled(false);
        btnRoupa3.setEnabled(false);
        lblCode.setEditable(false);

        s.setLocationRelativeTo(null);
        s.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Roupa")){
            lblCode.setText(code);
            btnRoupa.setEnabled(false);
            btnRoupa1.setEnabled(true);
            btnRoupa2.setEnabled(true);
            btnRoupa3.setEnabled(true);

        }
        else if(s.equals("blusaMangaPreta")){
            vars.setClothes(1);
            String roupa = vars.getClothes() == 1 ? "\"blusaMangaPreta\"": vars.getClothes() == 2? "\"blusaMangaBranca\"" : "\"Pijama\"";
            code = "def Clothes():\n\tclothes = " + roupa;
            lblCode.setText(code);
        }
        else if(s.equals("blusaMangaBranca")){
            vars.setClothes(2);
            String roupa = vars.getClothes() == 1 ? "\"blusaMangaPreta\"": vars.getClothes() == 2? "\"blusaMangaBranca\"" : "\"Pijama\"";
            code = "def Clothes():\n\tclothes = " + roupa;
            lblCode.setText(code);
        }
        else if(s.equals("pijama")){
            vars.setClothes(3);
            String roupa = vars.getClothes() == 1 ? "\"blusaMangaPreta\"": vars.getClothes() == 2? "\"blusaMangaBranca\"" : "\"Pijama\"";
            code = "def Clothes():\n\tclothes = " + roupa;
            lblCode.setText(code);
        }
    }
}