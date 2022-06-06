import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Level3 {
    private Image imageBackgroud;
    Handler handler;
    Vars vars;
    Dog dog;
    SchoolDoor schoolDoor;

    public Level3(Handler handler, Vars vars){
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
                    dog = new Dog(650, 350, 100, 300, ID.Dog, tempObject, vars);
                    schoolDoor = new SchoolDoor(0, 400, 100, 300, ID.SchoolDoor, tempObject, vars);

                }
            }
            handler.addObject(schoolDoor);
            handler.addObject(dog);
            vars.setInitializedScreen(true);
        }
    }
    public Graphics render(Graphics g) {
        ImageIcon fundo = new ImageIcon("Scenes\\rua2.png");
        imageBackgroud = fundo.getImage();
        //g.fillRect(x, y, 32, 64);
        g.drawImage(imageBackgroud, 0, 0, Main.WIDTH, Main.HEIGHT, null);
        //g.setColor(new Color(240, 200, 240));
        //g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        
        return g;

    }


}
