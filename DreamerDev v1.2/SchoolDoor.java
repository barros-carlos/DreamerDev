import java.awt.Color;
import java.awt.Graphics;

import java.awt.Font;


public class SchoolDoor extends GameObject {

    Handler handler;
    Player player;
    Vars vars;


    public SchoolDoor(int x, int y,int width, int height, ID id, GameObject gameObject, Vars vars) {
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
            g.fillRect(x-25+width/2+50, y+50, 50, 50);

            Font font = new Font("Arial", Font.BOLD, 45);
            g.setFont(font);
            g.setColor(new Color(255, 255, 255));
            g.drawString("E",   (int) (x-25+width*0.60)+50, y+40+50);
        } 
        //g.setColor(new Color(200, 50, 220));
        //g.fillRect(x, y, width, height);
        
    }
    @Override
    public void actionPlayer() {
        vars.setCurrentLevel(vars.getCurrentLevel() == 3? 4: vars.getCurrentLevel() == 4 ? 5 : 1);
        vars.setInitializedScreen(false);
    }
    
}