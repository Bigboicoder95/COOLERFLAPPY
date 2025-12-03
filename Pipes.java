import java.awt.*;

public class Pipes {
    double x = 300;
    double yUp = 200;
    double yDown = 400;

    public Pipes(double initialX){
        x= initialX;
        yUp = 200;
        yDown = 400;
        randomizeHeight();
    }

    public void randomizeHeight(){
        double y = (150 + (Math.random()*(450 - 150 + 1)));
        yUp = y - 150;
        yDown = y + 150;
    }

    public void reset(double initialX){
        x= initialX;
        yUp = 200;
        yDown = 400;
        randomizeHeight();
    }

    public boolean collideWith(Bird bir){
        if (((x <= 130) && (100 <= x+50) && ((bir.height+30) >= yDown)) || ((x <= 130) && (100 <= x+50) &&  (bir.height <= (yUp)))){
            return true;
        }
        return false;
    }

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect((int) x,(int) yDown, 50, 500);
        g.fillRect((int) x,(int) (yUp - 500), 50, 500);
    }

    public void update(double dt, Bird bir){
        x -= (bir.speed*dt);
         if (x < -50) {
            x = 950;
            x -= (210*dt);
            randomizeHeight();
        }
    }
}
