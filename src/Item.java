import javax.swing.*;
import java.awt.*;

public class Item {
    private String affectedStat; //Statistique affectée
    private String method; // % ou valeur fixe
    private int value;
    private String name;
    private int quantity;
    private Image icon;

    public Item(String name, String iconDir, String affectedStat, String method, int value, int quantity){
        this.name = name;
        loadImage(iconDir);
        this.affectedStat = affectedStat;
        this.method = method;
        this.value = value;
        this.quantity = quantity;
    }

    public Item(String name, String iconDir, String affectedStat, String method, int value){
        this(name, iconDir, affectedStat, method, value, 1);
    }

    public void loadImage(String iconDir){
        ImageIcon ii = new ImageIcon(iconDir);
        this.icon = ii.getImage();
    }

    public String getAffectedStat() {
        return affectedStat;
    }

    public void setAffectedStat(String affectedStat) {
        this.affectedStat = affectedStat;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }
}
