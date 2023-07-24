package ku.cs.services;

import ku.cs.models.ShoeList;
public class ShoeHardCodeDatasource {
    public ShoeList readData() {
        ShoeList list = new ShoeList();
        list.addNewShoe("NI001","Nike Air Max 1", "38");
        list.addNewShoe("NI002","Nike Air Force", "37");
        list.addNewShoe("AD001","Adidas SamSam", "40");
        list.addNewShoe("AD002","Adidas M1 Pro", "42");
        return list;
    }
}
