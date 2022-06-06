import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;


public class Dog extends GameObject {

    Handler handler;
    Player player;
    Vars vars;
    JFrame s;
    JTextArea lblCode;
    String code;
    JButton btnRoupa, btnRoupa1, btnRoupa2, btnRoupa3;

    public Dog(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
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

            Font font = new Font("Arial", Font.BOLD, 45);
            g.setFont(font);
            g.setColor(new Color(20, 20, 20));
            g.drawString("Wooff!!",   750, 350);
        } 
        //g.setColor(new Color(200, 50, 220));
        //g.fillRect(x, y, width, height);
        
    }
}