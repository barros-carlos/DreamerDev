import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Level5 {
    private Image imageBackgroud;
    Handler handler;
    Vars vars;
    Computer computer;

    public Level5(Handler handler, Vars vars){
        this.handler = handler;
        this.vars = vars;

        if (!vars.getInitializedScreen()){
            while(handler.object.size() > 1){
                for(int i = 0; i < handler.object.size(); i++){
                    GameObject tempObject = handler.object.get(i);
                    
                    if(tempObject.getId() !=  ID.Player){
                        handler.removeObject(tempObject);
                    }
                }
            }
            for(int i = 0; i < handler.object.size(); i++){

                GameObject tempObject = handler.object.get(i);
                if(tempObject.getId() ==  ID.Player){
                    tempObject.setX(20);
                    tempObject.setY(520);
                    computer = new Computer(1100, 450, 200, 200, ID.Computer, tempObject, vars);
                }
            }
            handler.addObject(computer);
            vars.setInitializedScreen(true);
        }
    }
    public Graphics render(Graphics g) {
        ImageIcon fundo = new ImageIcon("Scenes\\salaEscola.png");
        imageBackgroud = fundo.getImage();
        //g.fillRect(x, y, 32, 64);
        g.drawImage(imageBackgroud, 0, 0, Main.WIDTH, Main.HEIGHT, null);
        //g.setColor(new Color(240, 200, 240));
        //g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        
        return g;
    }
}
