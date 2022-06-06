import java.awt.Graphics;

public abstract class GameObject {

    protected int x, y, width, height; 
    protected int velX, velY, acelleration = 1;
    protected ID id;    
    private boolean interaction = false;


    public GameObject(int x, int y, int width, int height, ID id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public ID getId(){
        return id;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getAcelleration(){
        return acelleration;
    }
    public void setAcelleration(int acelleration){
        this.acelleration = acelleration;
    }
    public boolean collision(GameObject object){
		if(x + width >= object.x && object.x + object.width >= x && y + height >= object.y && object.y + object.height >= y ){
            
            return true;
		}
        return false;
    }
    public boolean interaction(GameObject object){
        if(x + width >= object.x - 16 && object.x + object.width + 16 >= x &&
		y + height >= object.y - 16 && object.y + object.height + 16 >= y){
            return true;   
        }
        return false;
    } 
    public boolean getInteration(){
        return interaction;
    }
    public void setInteraction(boolean interaction){
        this.interaction = interaction;
    }
    public void actionPlayer(){
        
    }

}
