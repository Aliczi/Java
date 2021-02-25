import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
import java.util.ArrayList;




public class GameLoop extends JPanel implements KeyListener, ActionListener{
    private boolean play = false;
    private int score;
    private int totalBlocks;
    

    private Timer timer;
    private int delay = 8;
    private Racket r;
    private Ball b;
    private ArrayList<Block> blocks;
    

    public GameLoop() {
        r = new Racket();
        b = new Ball();
        totalBlocks = 8;

        //blocks
        blocks = new ArrayList<Block>();
        Block b1 = new Block(100,100);
        Block b2 = new Block(100,200);
        Block b3 = new Block(250,100);
        Block b4 = new Block(250,200);
        Block b5 = new Block(400,100);
        Block b6 = new Block(400,200);
        Block b7 = new Block(550,100);
        Block b8 = new Block(550,200);
        blocks.add(b1);
        blocks.add(b2);
        blocks.add(b3);
        blocks.add(b4);
        blocks.add(b5);
        blocks.add(b6);
        blocks.add(b7);
        blocks.add(b8);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }


    

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        //racket and ball
        r.draw((Graphics2D) g);
        b.draw((Graphics2D) g);

        //blocks
        for (Block b : blocks) if(b.visible) b.draw((Graphics2D) g);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(683, 0, 3, 592);

        //scores
        g.setColor(Color.white);
        g.setFont(new Font ("serif", Font.BOLD, 25));
        g.drawString(""+score,590,30);
        g.setFont(new Font ("serif", Font.BOLD, 20));
        g.drawString("Press Enter to restart",5,30);

        
        if(totalBlocks <= 0){
            play=false;
            b.ballXdir = 0;
            b.ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font ("serif", Font.BOLD, 25));
            g.drawString("Victory!, Score: "+ score, 230, 300);

            g.setFont(new Font ("serif", Font.BOLD, 25));
            g.drawString("Press Enter to restart", 230, 350);
        }

        
        if(b.ballposY >570){
            play=false;
            b.ballXdir = 0;
            b.ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font ("serif", Font.BOLD, 25));
            g.drawString("Game Over, Score: "+score,230,300);

            g.setFont(new Font ("serif", Font.BOLD, 25));
            g.drawString("Press Enter to restart",230,350);
        }

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            if (b.collision(r)) b.ballYdir = -b.ballYdir;
            for (Block blo : blocks) {
                if (blo.visible && b.collision(blo)){
                    blo.hideBlock();
                    totalBlocks--;
                    score += 5;
                    if (b.ballposX + b.width - 1 <= blo.posX || b.ballposX + 1 >= blo.posX + blo.width) b.ballXdir = -b.ballXdir;
                    else b.ballYdir = -b.ballYdir;
                    break;
                }
            }

        }
        b.move();
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(r.posX >= 600) r.posX = 600;
            else {play = true; r.moveRight();}
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if(r.posX < 10) r.posX = 10;
            else {play = true; r.moveLeft(); }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            if(r.posY >= 539) r.posY = 540;
            else {play = true; r.moveDown(); }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            if(r.posY <= 500) r.posY = 500;
            else {play = true; r.moveUp(); }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            if(true){
                play = true;
                b.ballposX =120;
                b.ballposY = 350;
                b.ballXdir = -2;
                b.ballYdir = -3;
                r.posX = 310;
                r.posY = 550;
                score =0;
                totalBlocks = 8;
                for (Block b : blocks) b.visible = true;

                repaint();
            }
        }
    }  
}
