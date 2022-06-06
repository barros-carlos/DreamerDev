import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Level4 {
    private Image imageBackgroud;
    Handler handler;
    Vars vars;
    Cabinet cabinet;
    SchoolDoor schoolDoor;

    public Level4(Handler handler, Vars vars){
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
                    tempObject.setX(1150);
                    tempObject.setY(520);
                    cabinet = new Cabinet(350, 400, 75, 300, ID.Cabinet, tempObject, vars);
                    schoolDoor = new SchoolDoor(10, 400, 80, 200, ID.SchoolDoor, tempObject, vars);
                }
            }
            handler.addObject(cabinet);
            handler.addObject(schoolDoor);
            vars.setInitializedScreen(true);
        }
    }
    public Graphics render(Graphics g) {
        ImageIcon fundo = new ImageIcon(vars.getLvl4State() ? "Scenes\\corredor2.png" : "Scenes\\corredor1.png");
        imageBackgroud = fundo.getImage();
        //g.fillRect(x, y, 32, 64);
        g.drawImage(imageBackgroud, 0, 0, Main.WIDTH, Main.HEIGHT, null);
        //g.setColor(new Color(240, 200, 240));
        //g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        
        return g;

    }


}
