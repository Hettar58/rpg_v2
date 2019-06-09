import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatUI {
    public static CombatUI UI;
    private JPanel Root;
    private JButton AttaqueButton;
    private JButton ObjetsButton;
    private JButton MagieButton;
    private JButton FuiteButton;
    private JLabel PlayerLabel;
    private JProgressBar HPBar;
    private JLabel HPLabel;
    private JLabel MPLabel;
    private JPanel ControlPanel;
    private JPanel CenterPanel;
    private JPanel StatusPanel;
    private JProgressBar MPBar;

    public CombatUI(){
        Root = new JPanel();
        ControlPanel = new JPanel();
        CenterPanel = new JPanel();
        StatusPanel = new JPanel();
        AttaqueButton = new JButton("Attaque");
        ObjetsButton = new JButton("Objets");
        MagieButton = new JButton("Magie");
        FuiteButton = new JButton("Fuite");
        PlayerLabel = new JLabel("Joueur 1");
        HPBar = new JProgressBar();
        HPLabel = new JLabel("HP");
        MPBar = new JProgressBar();
        MPLabel = new JLabel("MP");

        Root.setLayout(new BorderLayout());
        ControlPanel.setLayout(new GridLayout(4, 1));
        CenterPanel.setLayout(null);
        StatusPanel.setLayout(new GridLayout(3, 2));

        ControlPanel.add(AttaqueButton);
        ControlPanel.add(ObjetsButton);
        ControlPanel.add(MagieButton);
        ControlPanel.add(FuiteButton);

        StatusPanel.add(PlayerLabel);
        StatusPanel.add(new JPanel());
        StatusPanel.add(HPLabel);
        StatusPanel.add(HPBar);
        StatusPanel.add(MPLabel);
        StatusPanel.add(MPBar);

        Root.add(ControlPanel, BorderLayout.WEST);
        Root.add(CenterPanel, BorderLayout.CENTER);
        Root.add(StatusPanel, BorderLayout.EAST);

        UI = this;
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
