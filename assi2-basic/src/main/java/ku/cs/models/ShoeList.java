package ku.cs.models;

import java.util.ArrayList;
public class ShoeList {
    private ArrayList<Shoe> shoes;

    public ShoeList() {
        shoes = new ArrayList<>();
    }

    public void addNewShoe(String id, String name, String size) {
        id = id.trim();
        name = name.trim();
        size = size.trim();
        if (!id.equals("") && !name.equals("") && !size.equals("")) {
            Shoe exist = findShoesById(id);
            if (exist == null) {
                shoes.add(new Shoe(id.trim(), name.trim(), size.trim()));
            }
        }
    }
    public Shoe findShoesById(String id) {
        for (Shoe shoe : shoes) {
            if (shoe.isId(id)) {
                return shoe;
                /* check id คนนั้นใน shoe */
            }
        }
        return null;
    }
    public void givePriceToId(String id, double price) {
        Shoe exist = findShoesById(id);
        if (exist != null) {
            exist.addPrice(price);
            /* ถ้ามีก็ไม่เป็น null */
        }
    }

    public ArrayList<Shoe> getShoes() {
        return shoes;
    }

}

