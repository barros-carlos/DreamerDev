import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Level1 {
    private Image imageBackgroud;
    Handler handler;
    Wardrobe wardrobe;
    BedroomDoor bedroomDoor;
    Player player;

    public Level1(Handler handler, Vars vars, Player player){
        this.handler = handler;
        this.player = player;


        if (!vars.getInitializedScreen()){
            handler.addObject(player);
            player.ResetChronometer();
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
                    tempObject.setX(1100);
                    tempObject.setY(550);
                    bedroomDoor = new BedroomDoor(0, 420, 100, 200, ID.BedroomDoor, tempObject, vars);
                    wardrobe = new Wardrobe(644, 420, 204, 200, ID.Wardrobe, tempObject, vars);
                }
            }
            handler.addObject(wardrobe);
            handler.addObject(bedroomDoor);
            vars.setInitializedScreen(true);
        }
    }
    public Graphics render(Graphics g) {
        ImageIcon fundo = new ImageIcon("Scenes\\quarto.png");
        imageBackgroud = fundo.getImage();
        //g.fillRect(x, y, 32, 64);
        g.drawImage(imageBackgroud, 0, 0, Main.WIDTH, Main.HEIGHT, null);
        //g.setColor(new Color(240, 200, 240));
        //g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        
        return g;
    }


}
