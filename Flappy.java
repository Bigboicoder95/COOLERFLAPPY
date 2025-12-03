import java.awt.*;
import java.util.ArrayList;

public class Flappy extends GBSGame {

    // Game Variables
    // - Only declare variables here, initialize them in setup()
    Bird bir = new Bird();
    Bird bir2 = new Bird();
    int count1 = 0;
    int count2 = 0; 

    ArrayList<BirdShadow> shadows = new ArrayList<>();
    ArrayList<BirdShadow> shadows2 = new ArrayList<>();

    String color;
    Pipes p1 = new Pipes(300);
    Pipes p2 = new Pipes(600);
    Pipes p3 = new Pipes(800);
    Pipes p4 = new Pipes(1000);
    Pipes p5 = new Pipes(1200);
    int space = 0;
    boolean gameOver;
    double score = 0;

    double timer = 0;
    double timerOffset = .0075;

    public void setup() {
        score = 0;
        timer = 0;
    }

    @Override
    public void update(double dt) {

        if (super.keyDown("r")) {
            bir.reset();
            bir2.reset();
            score = 0;
            p1.reset(300);
            p2.reset(600);
            p3.reset(800);
            p4.reset(1000);
            p5.reset(1200);
            space = 0;
            gameOver = false;
            shadows.clear();
            shadows2.clear();

        }
        timer += dt;
        if (timer > timerOffset) {
            shadows.add(new BirdShadow(bir.height));
            shadows2.add(new BirdShadow(bir2.height));
        }
        
        if (gameOver) {
            return;
        }
        if (super.keyDown(",")) {
            bir.jump(-400);
        }
        if (super.keyDown("t")) {
            bir2.jump(-400);
        }
        bir.update(dt, 1);
        bir2.update(dt, 1);
        for (int i = 0; i < shadows.size(); i++) {
            BirdShadow shadow = shadows.get(i);
            shadow.update(dt, 1, 0);
            shadow.checkForSelfDelete(shadows);
        }
        for (int i = 0; i < shadows2.size(); i++) {
            BirdShadow shadow2 = shadows2.get(i);
            shadow2.update(dt, 1, 0);
            shadow2.checkForSelfDelete(shadows2);
        }

        p1.update(dt, bir);
        p2.update(dt, bir);
        p3.update(dt, bir);
        p4.update(dt, bir);
        p5.update(dt, bir);
        score += dt;
        bir.isOffScreen();
        bir2.isOffScreen();
    }

    @Override
    public void draw(Graphics g) {
        bir.updateIntensity(score);
        bir.drawR(g);
        bir2.updateIntensity(score);
        bir2.drawR(g);
        if (p1.collideWith(bir) || p1.collideWith(bir2)) {
            if(gameOver == false){
            if(p1.collideWith(bir)){
                count2++;
            }
            else{
                count1++;
            }
        }
            g.setColor(Color.RED);
            gameOver = true;
        }
        if (p2.collideWith(bir) || p2.collideWith(bir2)) {
            if(gameOver == false){
            if(p2.collideWith(bir)){
                count2++;
            }
            else{
                count1++;
            }
        }
            g.setColor(Color.RED);
            gameOver = true;
        }
        if (p3.collideWith(bir) || p3.collideWith(bir2)) {
            if(gameOver == false){
            if(p3.collideWith(bir)){
                count2++;
            }
            else{
                count1++;
            }
        }
            g.setColor(Color.RED);
            gameOver = true;
        }
        if (p4.collideWith(bir) || p4.collideWith(bir2)) {
            if(gameOver == false){
            if(p4.collideWith(bir)){
                count2++;
            }
            else{
                count1++;
            }
        }
            g.setColor(Color.RED);
            gameOver = true;
        }
        if (p5.collideWith(bir) || p5.collideWith(bir2)) {
            if(gameOver == false){
            if(p5.collideWith(bir)){
                count2++;
            }
            else{
                count1++;
            }
        }
            g.setColor(Color.RED);
            gameOver = true;
        }
        bir.draw(g, 100, 1);
        bir2.draw(g, 100, 2);
        for (BirdShadow shadow: shadows) {
            shadow.updateIntensity(score);
            shadow.draw(g, 1);
        }
        for (BirdShadow shadow2: shadows2) {
            shadow2.updateIntensity(score);
            shadow2.draw(g, 2);
        }
        g.setColor(Color.YELLOW);
        g.setColor(Color.GREEN);
        p1.draw(g);
        p2.draw(g);
        p3.draw(g);
        p4.draw(g);
        p5.draw(g);
        g.setColor(Color.BLACK);
        g.drawString("Player 1: " + count1 + " \n" + "Player 2: " + count2 , 300, 50);
    }

    // Ignore these lines unless you want to change the framerate.
    // Game is designed for 400x600
    // If using dt properly in update, should work no matter what framerate you
    // select
    public static void main(String[] args) {
        Flappy f = new Flappy();
        f.setResolution(800, 600);
        f.setFrameRate(60);
        f.createWindow();
        f.setup();
    }
}
