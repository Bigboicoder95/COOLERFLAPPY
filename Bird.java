import java.awt.*;

public class Bird {
    double height = 285;
    double velocity  = 0;
    double speed = 210;
    int x = 100;
    double colorIntensity = 0;
    public Bird(){
        x = 100;
        height = 285;
        velocity = 0;
        speed = 210;
    }

    public void reset(){
        x = 100;
        height = 285;
        velocity = 0;
        speed = 210;
    }

    public void jump(int v) {
        velocity = v;
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
    

    public void updateIntensity(double score){
        //colorIntensity = score;
    }


    public void update(double dt, double m){
        velocity += (9.81*150*m*dt);
        height += (velocity*dt);
        speed += 60 * dt;
        colorIntensity+=0.6*dt;
    }

    public void draw(Graphics g, int x, int n){
        if (n == 1){
        g.setColor(new Color( Math.clamp(255-(int)colorIntensity*35, 0, 255), Math.clamp(255 - 200 + 2*x, 0, 255),  Math.clamp((int)colorIntensity*35, 0, 255)));
        }
        if (n==2){
        g.setColor(new Color( Math.clamp(255- 200 + 2*x, 0, 255), Math.clamp(255-(int)colorIntensity*35, 0, 255),  Math.clamp((int)colorIntensity*35, 0, 255)));    
        }
        g.fillRect(x,(int) height,30,30);
        g.setColor(Color.BLACK);
        g.drawString(n+"", this.x, (int) height+30);
    }
    public void drawR (Graphics g){
        if(colorIntensity>7.3){
            colorIntensity = 0;
        }
        g.setColor(new Color(   Math.clamp((int)colorIntensity*35 , 0, 255), Math.clamp(255 - 200 + 2*x, 0, 255),Math.clamp(255-(int)colorIntensity*35, 0, 255)));
        g.fillRect(0, 0, 800, 600);
    }
    public Bird runner(Bird r, int v){
        r.x = this.x-10;
        r.jump(v);
        r.update(0, 0);
        return r;
    }
}
