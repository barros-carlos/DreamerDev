import java.awt.Graphics;
//import java.awt.Image;
//import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class Level0 {
    //private Image imageBackgroud;
    Handler handler;
    Wardrobe wardrobe;
    BedroomDoor bedroomDoor;

    public Level0(Handler handler, Vars vars){
        this.handler = handler;



        if (!vars.getInitializedScreen()){
   


            vars.setInitializedScreen(true);
        }
    }
    public Graphics render(Graphics g) {
        //ImageIcon fundo = new ImageIcon("Scenes\\quarto.png");
        //imageBackgroud = fundo.getImage();
        //g.fillRect(x, y, 32, 64);
        //g.drawImage(imageBackgroud, 0, 0, Main.WIDTH, Main.HEIGHT, null);
        //g.setColor(new Color(240, 200, 240));
        //g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        String text1 = "Ola, seja bem-vindo ao mundo de Dreamer Dev...";
        String text2 = "Como pode ver você estava em um dia cansativo depois de uma prova";
        String text3 = "e chegou em casa muito cansado, acabou sonhando num mundo onde";
        String text4 = "pode controlar o 'codigo' dos objetos, desbrave esse pequeno";
        String text5 = "gigante mundo";
        String text6 = "Atencao, equipe DreamerDev.";
        g.setColor(new Color(50,5,25));
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(new Color(255, 255, 255));
        g.drawString(text1, 20, 60);
        g.drawString(text2, 20, 110);
        g.drawString(text3, 20, 160);
        g.drawString(text4, 20, 210);
        g.drawString(text5, 20, 260);
        g.drawString(text6, 20, Main.HEIGHT-70);
        g.drawString("Pressione Espaco para começar....", 780, Main.HEIGHT-70);



        
        return g;
    }


}
