import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inv;

    public Inventory(){inv = new ArrayList<Item>();}

    public void addItem(Item item, int quantity){
        boolean exist = false;

        for (Item i : inv){
            if (i.equals(item)){
                exist = true;
                i.setQuantity(i.getQuantity()+1);
            }
        }
        if (exist == false){
            inv.add(item);
        }
    }


}
