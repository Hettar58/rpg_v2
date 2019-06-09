import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static Main Game; //raccourci pour accéder à l'instance actuelle du jeu

    public static void main(String[] args){
        System.setProperty("file.encoding", "UTF-8");
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setSize(800, 600);
            app.setVisible(true);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setResizable(false);
        });
    }
    public Main(){
        Game = this;
        AnimatedSprite as1 = new AnimatedSprite(400, 300, false, false);
        as1.loadImage("src/textures/character/perso1_state2.png", 500);
        as1.loadImage("src/textures/character/perso1_state1.png", 500);
        as1.loadImage("src/textures/character/perso1_state3.png", 500);
        as1.loadImage("src/textures/character/perso1_state1.png", 500);

        AnimatedSprite as2 = new AnimatedSprite(200, 300, true, false);
        as2.loadImage("src/textures/character/perso1_state2.png", 500);
        as2.loadImage("src/textures/character/perso1_state1.png", 500);
        as2.loadImage("src/textures/character/perso1_state3.png", 500);
        as2.loadImage("src/textures/character/perso1_state1.png", 500);



        StaticEntity bg_top = new StaticEntity(0, 0, "src/textures/background/bg_top.png");
        StaticEntity bg_bottom = new StaticEntity(0, 0, "src/textures/background/bg_bottom.png");


        Render render = new Render();
        render.setLayout(null);
        add(render);

        CombatUI combatUI = new CombatUI();

        Render.instance.addToRenderPile(bg_bottom);
        Render.instance.addToRenderPile(bg_top);
        Render.instance.addToRenderPile(as1);

        render.addToRenderPile(as2);
        render.add(combatUI.getRootPanel());
        render.start();

    }

    public void attackButtonPressed(){
        AnimatedSprite effect = new AnimatedSprite(200, 210, false, true);
        effect.loadImage("src/textures/effects/Hit1_1.png", 100);
        effect.loadImage("src/textures/effects/Hit1_2.png", 100);
        effect.loadImage("src/textures/effects/Hit1_3.png", 100);
        effect.loadImage("src/textures/effects/Hit1_4.png", 100);
        Render.instance.addToRenderPile(effect);
    }
}
