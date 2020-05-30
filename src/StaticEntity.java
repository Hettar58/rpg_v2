import javax.swing.*;
import java.awt.*;

public class StaticEntity extends Sprite{
    public StaticEntity(int x, int y){
        super (x, y);
    }

    public StaticEntity(int x, int y, String dir){
        super(x, y);
        loadImage(dir);
    }

    public Image getTexture(){
        return this.texture;
    }

    public void loadImage(String dir){
        ImageIcon ii = new ImageIcon(dir);
        this.texture = ii.getImage();
        getImageDimensions();
    }
}
