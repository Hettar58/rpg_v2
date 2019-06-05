import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation {
    private ArrayList<AnimFrame> frames;
    private int currFrameIndex;
    private int animTime;
    private int totalDuration;
    private boolean loop;
    private boolean continuer;
    private boolean clear;

    public Animation(boolean loop, boolean clear){
        totalDuration = 0;
        this.loop = loop;
        this.clear = clear;
        frames = new ArrayList();
        if (clear == true){
            addFrame("src/textures/clear.png", 1);
        }
        start();
    }

    private void start(){
        animTime = 0;
        currFrameIndex = 0;
        this.continuer = true;
    }

    public void addFrame(String dir, long duration){
        totalDuration += duration;
        ImageIcon ii = new ImageIcon(dir);
        Image img = ii.getImage();
        frames.add(new AnimFrame(img, totalDuration));
    }

    public void update(long elapsedTime){
        if (frames.size() > 1){
            if (currFrameIndex != frames.size()){
                animTime += elapsedTime;
                if (animTime >= totalDuration){
                    if (loop == true){
                        animTime = animTime % totalDuration;
                        currFrameIndex = 0;
                        continuer = true;
                    }
                    else{
                        animTime = 0;
                        currFrameIndex = 0;
                        continuer = false;
                    }
                }
                if (continuer == true){
                    while (animTime > getFrame(currFrameIndex).endTime) {
                        currFrameIndex++;
                    }
                }
            }
        }
    }
    public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currFrameIndex).image;
        }
    }

    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

    public boolean isContinuer(){return this.continuer;}
    public boolean isClear(){return this.clear;}
    private class AnimFrame {

        Image image;

        long endTime;

        public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }

}


