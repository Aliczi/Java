import java.awt.*;


public class Block implements Item{

    public int posX;
    public int posY;
    public int height;
    public int width;
    public boolean visible;

    Block(int x, int y){
        posX = x;
        posY = y;
        height = 50;
        width = 50;
        visible = true;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.gray);
        g.fillRect(posX, posY, width, height);
        // g.setStroke(new BasicStroke(3));
        // g.setColor(Color.black);
        // g.fillRect(posX, posY, width, height);
    }

    @Override
    public Rectangle make_rect(){
        Rectangle a = new Rectangle(posX,posY,width,height);
        return a;
    }

    public void hideBlock(){
        visible = false;
    }
    
}
