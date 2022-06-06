import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyInput extends KeyAdapter implements ActionListener{

    Handler handler;
    Main main;
    Vars vars;
    Player player;
    Window window;
    Timer chronometer;

    public KeyInput(Handler handler, Main main, Vars vars, Window window){
        this.handler = handler;
        this.main = main;
        this.vars = vars;
        this.window = window;
        chronometer = new Timer(3000, (ActionListener) this);
    }
    
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                player = (Player) tempObject;
                if (key == KeyEvent.VK_D) {                                          
                    tempObject.setVelX(5);
                }
                if (key == KeyEvent.VK_A) {                                    
                    tempObject.setVelX(-5);
                }
                if (key == KeyEvent.VK_S) {                                    
                    tempObject.setVelY(5);
                }
                if (key == KeyEvent.VK_W) {                                    
                    tempObject.setVelY(-5);
                }
            }
            if(tempObject.getInteration()){
                if(key == KeyEvent.VK_E){
                    System.out.println("Interação ocorrida");
                    player.setVelX(0);
                    player.setVelY(0);

                    tempObject.actionPlayer();
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE){
            chronometer.start();
        }
        if(key == KeyEvent.VK_SPACE){
            if(vars.getCurrentLevel() == 0){
                vars.setCurrentLevel(1);
                vars.setInitializedScreen(false);
            }
            if(vars.getCurrentLevel() == 6){
                Game game = new Game(vars.getPlayerCode() , window.frame);
                
            }

        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();  

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_D) {                                          
                    tempObject.setVelX(0);;
                }
                if (key == KeyEvent.VK_A) {                                    
                    tempObject.setVelX(0);;
                }
                if (key == KeyEvent.VK_W) {                                    
                    tempObject.setVelY(0);;
                }
                if (key == KeyEvent.VK_S) {                                    
                    tempObject.setVelY(0);;
                }
                
            }
        }
        if(key == KeyEvent.VK_ESCAPE){
            chronometer.restart();
            chronometer.stop();
            
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        System.exit(1);
    }
}
