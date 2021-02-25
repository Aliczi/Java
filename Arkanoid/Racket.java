import java.awt.*;

public class Racket implements Item{


    public int posX;
    public int posY;
    public int height;
    public int width;

    Racket(){

        posX = 310;
        posY = 539;
        height = 8;
        width = 100;
    }

    @Override
    public void draw(Graphics2D g){
        g.setColor(Color.green);
        g.fillRect(posX, posY, width, height);
    }

    @Override
    public Rectangle make_rect(){
        Rectangle a = new Rectangle(posX,posY,width,height);
        return a;
    }

    public void moveRight(){
        this.posX+=20;
    }
    public void moveLeft(){
        this.posX-=20;
    }
    public void moveUp(){
        this.posY-=10;
    }
    public void moveDown(){
        this.posY+=10;
    }
}
