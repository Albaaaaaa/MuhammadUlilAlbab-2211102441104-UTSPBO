import greenfoot.*;

public class Wall extends Actor {
    public Wall() {
        GreenfootImage img = new GreenfootImage(15, 11);
        img.setColor(Color.WHITE);
        img.fill();
        setImage(img);
    }
}
