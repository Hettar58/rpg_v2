import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JPanel Root;
    private JButton AttaqueButton;
    private JButton ObjetsButton;
    private JButton MagieButton;
    private JButton Fuite;
    private JLabel PlayerLabel;
    private JProgressBar HPBar;
    private JLabel HPLabel;
    private JLabel MPLabel;
    private JProgressBar progressBar1;

    public UI(){
        Root.setBounds(50, 430, 700, 120);
        AttaqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Game.attackButtonPressed();
            }
        });
    }

    public JPanel getRootPanel(){
        return this.Root;
    }
}
