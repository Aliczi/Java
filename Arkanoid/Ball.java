import java.awt.*;

public class Ball implements Item{

    public int ballposX;
    public int ballposY;
    public int ballXdir;
    public int ballYdir;
    public int width;
    public int height;

    Ball(){
        ballposX = 120;
        ballposY = 350;
        width = 20;
        height = 20;
        ballXdir = -2;
        ballYdir = -3;
    }

    @Override
    public void draw(Graphics2D g){
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, width, height);
    }

    public void move(){
        ballposX += ballXdir;
        ballposY += ballYdir;
        if(ballposX < 0){
            ballXdir = -ballXdir;
        }
        if(ballposY < 0){
            ballYdir = -ballYdir;
        }
        if(ballposX > 670){
            ballXdir = -ballXdir;
        }
    }

    @Override
    public Rectangle make_rect(){
        Rectangle a = new Rectangle(ballposX,ballposY,width,height);
        return a;
    }
    public boolean collision(Item i){
        if (this.make_rect().intersects(i.make_rect())) return true;
        else return false;
    }
    
}
