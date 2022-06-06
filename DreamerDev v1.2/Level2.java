import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Level2 {
    private Image imageBackgroud;
    Handler handler;
    Pole pole;
    Vars vars;

    public Level2(Handler handler, Vars vars){
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


                /*if(tempObject.getId() ==  ID.Wardrobe){
                    handler.removeObject(tempObject);
                    System.out.println("armario removido");
                }
                if(tempObject.getId() ==  ID.BedroomDoor){
                    handler.removeObject(tempObject);
                    System.out.println("porta removida");
                }*/
                if(tempObject.getId() ==  ID.Player){
                    tempObject.setX(1150);
                    tempObject.setY(520);
                    pole = new Pole(1050, 420, 25, 200, ID.Pole, tempObject, vars);
                }
            }
            handler.addObject(pole);
            vars.setInitializedScreen(true);
        }
    }
    public Graphics render(Graphics g) {
        ImageIcon fundo = new ImageIcon(vars.getLvl2State()?"Scenes\\ruaSinalVermelho.png":"Scenes\\ruaSinalVerde.png");
        imageBackgroud = fundo.getImage();
        //g.fillRect(x, y, 32, 64);
        g.drawImage(imageBackgroud, 0, 0, Main.WIDTH, Main.HEIGHT, null);
        //g.setColor(new Color(240, 200, 240));
        //g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        

        return g;

    }


}
