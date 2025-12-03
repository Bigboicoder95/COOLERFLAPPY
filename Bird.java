import java.awt.*;

public class Bird {
    double height = 285;
    double velocity  = 0;
    double speed = 210;
    public Bird(){
        height = 285;
        velocity = 0;
        speed = 210;
    }

    public void reset(){
        height = 285;
        velocity = 0;
        speed = 210;
    }

    public void jump() {
        velocity = -400;
    }

    public void isOffScreen(){
        if (height > 570) {
            height = 570;
            velocity = 0;
        }
        if (height < 0) {
            height = 0;
        }
    }

    public void update(double dt){
        velocity += (9.81*150*dt);
        height += (velocity*dt);
        speed  += (60*dt);
    }

    public void draw(Graphics g){
        g.fillRect(100,(int) height,30,30);
    }
}
