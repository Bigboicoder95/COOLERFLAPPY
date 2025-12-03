import java.awt.*;
public class Flappy extends GBSGame {

    // Game Variables
    // - Only declare variables here, initialize them in setup()
    Bird bir = new Bird();
    String color;
    Pipes p1 = new Pipes(300);
    Pipes p2 = new Pipes(600);
    Pipes p3 = new Pipes(800);
    Pipes p4 = new Pipes(1000);
    Pipes p5 = new Pipes(1200);
    int space = 0;
    boolean gameOver;
    double score = 0;


    public void setup() {
        score = 0;
    }

    @Override
    public void update(double dt) {
        
        if (super.keyDown("r")){
            bir.reset();
            score = 0;
            p1.reset(300);
            p2.reset(600);
            p3.reset(800);
            p4.reset(1000);
            p5.reset(1200);
            space = 0;
            gameOver = false;

        }
        if (gameOver) {
            return;
        }
        if(super.keyDown(",")){
            bir.jump();
        }
        bir.update(dt);
        p1.update(dt, bir);
        p2.update(dt, bir);
        p3.update(dt, bir);
        p4.update(dt, bir);
        p5.update(dt, bir);
        score += dt;
        bir.isOffScreen();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,800,600);
        g.setColor(Color.YELLOW);
        if (p1.collideWith(bir)){
            g.setColor(Color.RED);    
            gameOver = true;
        }
        if (p2.collideWith(bir)){
            g.setColor(Color.RED);    
            gameOver = true;
        }
        if (p3.collideWith(bir)){
            g.setColor(Color.RED);    
            gameOver = true;
        }
        if (p4.collideWith(bir)){
            g.setColor(Color.RED);    
            gameOver = true;
        }
        if (p5.collideWith(bir)){
            g.setColor(Color.RED);    
            gameOver = true;
        }
        bir.draw(g);
        g.setColor(Color.GREEN);
        p1.draw(g);
        p2.draw(g);
        p3.draw(g);
        p4.draw(g);
        p5.draw(g);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score + " seconds", 50, 50);
    }



    // Ignore these lines unless you want to change the framerate. 
    // Game is designed for 400x600
    // If using dt properly in update, should work no matter what framerate you select
    public static void main(String[] args) {
        Flappy f = new Flappy();
        f.setResolution(800, 600);
        f.setFrameRate(60);
        f.createWindow();
        f.setup();
    }
}
