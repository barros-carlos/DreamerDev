import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Vars {
    int playerCode;
    boolean initialized = false;
    private int currentLevel = 0;
    private int clothes = 1;
    private boolean lvl2State = true;
    private boolean lvl4State = true;
    private String time;
    ConnectionDB con;
    Vars(int playerCode, ConnectionDB con){
        this.playerCode = playerCode;
        this.con = con;
    }
    public boolean getInitializedScreen(){
        return initialized;
    }
    public void setInitializedScreen(boolean initialized){
        this.initialized = initialized;
    }
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }
    public int getClothes(){
        return clothes;
    }
    public void setClothes(int clothes){
        this.clothes = clothes;
    }
    public boolean getLvl2State(){
        return lvl2State;
    }
    public void setLvl2State(boolean lvl2State){
        this.lvl2State = lvl2State;
    }
    public boolean getLvl4State(){
        return lvl4State;
    }
    public void setLvl4State(boolean lvl4State){
        this.lvl4State = lvl4State;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return time;
    }
    public int getPlayerCode() {
        return playerCode;
    }

}
