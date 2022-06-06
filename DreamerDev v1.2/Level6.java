import java.awt.Graphics;
//import java.awt.Image;
//import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class Level6{
    //private Image imageBackgroud;
    Handler handler;
    Vars vars;
    ConnectionDB con;

    public Level6(Handler handler, Vars vars, ConnectionDB con){
        this.handler = handler;
        this.vars = vars;
        this.con = con;

        if (!vars.getInitializedScreen()){
            while(handler.object.size() > 0){
                for(int i = 0; i < handler.object.size(); i++){
                    GameObject tempObject = handler.object.get(i);
                    
                        handler.removeObject(tempObject);
                }
            }
            con.RecordTimePlayer(vars.getPlayerCode(), vars.getTime());

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

        String text1 = "Voce finalizou o Jogo";
        String text2 = "Seu tempo foi de " + vars.getTime();
        String text3 = "Obrigado por jogar o nosso jogo";
        String text4 = "Esse foi um projeto do nosso da materia";
        String text5 = "Projeto Integrador Interdisciplinar";
        String text6 = "Agradecimentos aos Professores Alexsander, Andreia, Aparecido e Antonio";
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
        g.drawString(text6, 20, 310);
        g.drawString("Pressione Espaco para Finalizar....", 780, Main.HEIGHT-70);



        
        return g;
    }


}
