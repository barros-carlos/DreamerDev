import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
//import java.util.Random;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 1312;
    public static final int HEIGHT = 748;
    final int TICKS_PER_SECOND = 60;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 50;

    
    private Thread thread;
    private boolean running = false;
    
    //private Random r;
    
    private Handler handler;
    private Player player;
    private Vars vars;
    Level0 lvl0;
    Level1 lvl1;
    Level2 lvl2;
    Level3 lvl3;
    Level4 lvl4;
    Level5 lvl5;
    Level6 lvl6;
    ConnectionDB con = new ConnectionDB();
    public Main(JFrame s, int playerCode){
        s.dispose();
        vars = new Vars(playerCode, con);
        handler = new Handler();
        Window window = new Window(WIDTH, HEIGHT, "DreamerDev", this);
        window.requestFocus();
        //box = new Box(50, 50, 50, 50, ID.Box);
        player = new Player(1100, 550, 70, 140, ID.Player, handler, this, vars);
        
        this.addKeyListener(new KeyInput(handler, this, vars, window));
        
        //r = new Random();
        //handler.addObject(player);
        //handler.addObject(box);
        //handler.addObject(wardrobe);

        /*for(int i = 0; i < 200; i++){
            handler.addObject(new Rain(r.nextInt(WIDTH), r.nextInt(1500)-1532, 0, 2, 32, ID.Rain));
            handler.addObject(new RainThic(r.nextInt(WIDTH), r.nextInt(1500)-1532, 0, 4, 32, ID.RainThic));
        }*/
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){

        double next_game_tick = System.currentTimeMillis();
        int loops;

        while (running) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP) {

                tick();

                next_game_tick += SKIP_TICKS;
                loops++;
			}
        render();
        }
    }

    private void tick(){
        handler.tick();

        for(int i = 0; i < handler.object.size(); i++){

            //GameObject tempObject = handler.object.get(i);

        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        
        
        switch(vars.getCurrentLevel()){
            case 0:
                lvl0 = new Level0(handler, vars);
                g = lvl0.render(g);
                break;
            case 1:
                lvl1 = new Level1(handler, vars, player);
                g = lvl1.render(g);
                break;
            case 2:
                lvl2 = new Level2(handler, vars);
                g = lvl2.render(g);
                break;
            case 3:
                lvl3 = new Level3(handler, vars);
                g = lvl3.render(g);
                break;
            case 4:
                lvl4 = new Level4(handler, vars);
                g = lvl4.render(g);
                break;
            case 5:
                lvl5 = new Level5(handler, vars);
                g = lvl5.render(g);
                break;
            case 6:
                lvl6 = new Level6(handler, vars, con);
                g = lvl6.render(g);
                break;
            default:
            break;
        }
        handler.render(g);
        
        //handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int Clamp(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if( var <= min)
            return var = min;
        else
            return var;
    }
}
