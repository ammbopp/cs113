package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Shoe;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class ShoeController {
    @FXML
    Label nameLabel;
    @FXML
    Label priceLabel;

    @FXML
    Label priceLabel1;
    @FXML
    Label cmLabel;

    @FXML
    public void initialize() {
        Shoe nike = new Shoe("D001","Dara For 1", "35");
        nike.addPrice(200);
        showShoe(nike);
    }

    private void showShoe(Shoe nike) {
        nameLabel.setText(nike.getName());
        priceLabel.setText(String.valueOf(nike.getPriceInUSD()));
        priceLabel1.setText(String.valueOf(nike.getPriceInTHB()));
        cmLabel.setText(nike.getSize());
    }

    @FXML
    public void onHandleBackButton(){
        try{
            FXRouter.goTo("shoe-list");
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}