import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class Player extends GameObject implements ActionListener {

    private Image playerSprite;
    Main main;
    Handler handler;
    int dir = 1, miliseconds, seconds, minutes;
    Timer chronometer;
    Vars vars;

    public Player(int x, int y, int width, int height, ID id, Handler handler, Main main, Vars vars) {
        super(x, y, width, height, id);
        this.main = main;
        this.vars = vars;
        seconds = 0;
        minutes = 0;
        chronometer = new Timer(50, (ActionListener) this);
    }


    /*public void collision(GameObject object){
            if(x + width >= object.getX() && object.getX() + object.getWidth() >= x && 
            y + height >= object.getY() && object.getY() + object.getHeight() >= y && this.getLife() > 0){

               
            }
    }*/
    

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;
        if (vars.getCurrentLevel() == 1){
            x = Main.Clamp(x, 0, (int) (Main.WIDTH-this.getWidth()));
            y = Main.Clamp(y, 500, Main.HEIGHT-getHeight());

        } else if (vars.getCurrentLevel() == 2){
            if(vars.getLvl2State()){
                x = Main.Clamp(x, 1000, Main.WIDTH-getWidth());
                y = Main.Clamp(y, 500, Main.HEIGHT-getHeight()-70);
            }
            else{
                x = Main.Clamp(x, 0, Main.WIDTH-getWidth());
                y = Main.Clamp(y, 500, Main.HEIGHT-getHeight()-70);
            }
            if(this.getX() < 100){
                vars.setCurrentLevel(3);
                vars.setInitializedScreen(false);
            }

        } else if (vars.getCurrentLevel() == 3){
            x = Main.Clamp(x, 0, Main.WIDTH-getWidth());
            y = Main.Clamp(y, 500, Main.HEIGHT-getHeight()-70);

        } else if (vars.getCurrentLevel() == 4){
            x = Main.Clamp(x, 0, (int) (Main.WIDTH-this.getWidth()));
            y = Main.Clamp(y, 500, Main.HEIGHT-getHeight());

        } else if (vars.getCurrentLevel() == 5){
            x = Main.Clamp(x, 0, (int) (Main.WIDTH-this.getWidth()));
            y = Main.Clamp(y, 500, Main.HEIGHT-this.getHeight());

        } else {
            x = Main.Clamp(x, 0, Main.WIDTH-getWidth());
            y = Main.Clamp(y, 0, Main.HEIGHT-getHeight());

        }
    }

    @Override
    public void render(Graphics g) {
        ImageIcon adam;
        switch(vars.getClothes()){
            case 1:
                adam = new ImageIcon("Sprites\\Adam.png");
                break;
            case 2:
                adam = new ImageIcon("Sprites\\Adam2.png");
                break;
            case 3:
                adam = new ImageIcon("Sprites\\AdamPijama.png");
                break;
            default:
                adam = new ImageIcon("Sprites\\Adam.png");
                break;
        }

        playerSprite = adam.getImage();

        //g.fillRect(x, y, 32, 64);
        if (getVelX() > 0)
            dir = 1;  
        else if (getVelX() < 0)
            dir = -1;
        if(dir == 1)
            g.drawImage(playerSprite, x, y, width, height, null);
        else 
            g.drawImage(playerSprite, x+width, y, width*dir, height, null);

        Font font = new Font("Arial", Font.BOLD, 30);

        g.setFont(font);
        g.setColor(new Color(10, 10, 10));
    
        // Draw a string such that its base line is at x, y
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 200, 60);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(20, 20, 180, 40);
        g.setColor(Color.BLACK);

        DecimalFormat df = new DecimalFormat("00");
        DecimalFormat dfMili = new DecimalFormat("000");

        g.drawString((df.format(minutes)+":"+df.format(seconds)+":"+dfMili.format(miliseconds*50)), 35, 50);
    
    }

    @Override
    public void actionPerformed(ActionEvent e){
        miliseconds++;
        if(miliseconds == 20){
            seconds++;
            miliseconds = 0;
            if(seconds == 60){
                minutes++;
                seconds = 0;
            }
        }
    }
    public void ResetChronometer(){
        miliseconds = 0;
        seconds = 0;
        minutes = 0;
        chronometer.start();
    }
    public void StopChronometer(){
        DecimalFormat df = new DecimalFormat("00");
        DecimalFormat dfMili = new DecimalFormat("000");
        vars.setTime((df.format(minutes)+":"+df.format(seconds)+":"+dfMili.format(miliseconds*50)));
        chronometer.stop();
    }
    public void penaliteTime(){
        seconds += 5;
    }
}
