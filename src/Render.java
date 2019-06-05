import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Render extends JPanel implements ActionListener {
    public static Render instance;
    private FPSCounter fps;
    private Timer timer;
    private int DELAY;
    private ArrayList<Sprite> RenderPile;
    private long currTime;

    public Render(){
        instance = this;
        fps = new FPSCounter();
        System.out.println("Rendu crée");
        RenderPile = new ArrayList<Sprite>();
        DELAY = 15;
        timer = new Timer(DELAY, this);
        timer.start();
        currTime = System.currentTimeMillis();
    }

    public void start(){
        setBackground(Color.WHITE); //le rafraichissement démarre ici
        fps.start();
    }

    private synchronized void draw(Graphics g){
        fps.frame();
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.drawString("Rendu en cours", 100, 100);

        //Pour le rendu : Le premier élément dans la pile est le premier dessiné.
        //Avec les autres éléments qui se dessinent par dessus
        for (Sprite sp : RenderPile){
            g2d.drawImage(sp.getTexture(), sp.getX(), sp.getY(), this);
        }
        g2d.setColor(Color.CYAN);
        g2d.drawString("FPS: "+fps.get(), 0, 10);
    }

    public void addToRenderPile(Sprite spr){
        RenderPile.add(spr);
    }

    public void removeInRenderPile(Sprite spr){
        RenderPile.remove(spr);
    }

    @Override
    public synchronized void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        long elapsedTime = System.currentTimeMillis() - currTime;
        currTime += elapsedTime;
        for (int i = 0; i <  RenderPile.size(); i++){
            if (RenderPile.get(i).getClass().getName().equals("AnimatedSprite")){
                AnimatedSprite tmp = (AnimatedSprite)(RenderPile.get(i));
                tmp.updateAnim(elapsedTime);
            }
        }
        repaint();
    }
}
