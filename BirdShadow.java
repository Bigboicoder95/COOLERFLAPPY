import java.awt.*;
import java.util.ArrayList;

public class BirdShadow {
    double height = 285;
    double velocity  = 0;
    double speed = 210;
    int x = 100;
    double colorIntensity = 0;
    public BirdShadow(double spawnHeight){
        x = 100;
        height = spawnHeight;
        speed = 210;
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

    public void checkForSelfDelete(ArrayList<BirdShadow> shadows) {
        if (this.x < -1) {
            shadows.remove(this);
        }
    }

    public void updateIntensity(double score){
        colorIntensity = score;
    }

    public void update(double dt, double m, int y){
        x-=300*dt;
    }

    public void draw(Graphics g, int n){
        if (n == 1){
        g.setColor(new Color( Math.clamp(255-(int)colorIntensity*35, 0, 255), Math.clamp(255 - 200 + 2*x, 0, 255),  Math.clamp((int)colorIntensity*35, 0, 255)));
        }
        if (n==2){
        g.setColor(new Color( Math.clamp(255 - 200 + 2*x, 0, 255), Math.clamp(255-(int)colorIntensity*35, 0, 255),  Math.clamp((int)colorIntensity*35, 0, 255)));    
        }
        g.fillRect(this.x,(int) height,30,30);
        g.setColor(Color.BLACK);
        g.drawString(n+"", this.x, (int) height+30);
    }
}
