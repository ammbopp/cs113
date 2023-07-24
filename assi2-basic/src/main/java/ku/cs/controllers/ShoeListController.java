package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.Shoe;
import ku.cs.models.ShoeList;
import ku.cs.services.FXRouter;
import ku.cs.services.ShoeHardCodeDatasource;

import java.io.IOException;
public class ShoeListController {
    @FXML private ListView<Shoe> shoeListView;
    @FXML private Label idLabel;
    @FXML private Label nameLabel;
    @FXML private Label sizeLabel;
    @FXML private Label priceLabel;
    @FXML private Label priceLabel1;
    @FXML private Label errorLabel;
    @FXML private TextField givePriceTextField;

    private ShoeList shoeList;
    private Shoe selectedShoe;

    @FXML
    public void initialize() {
        errorLabel.setText("");
        clearShoeInfo();
        ShoeHardCodeDatasource datasource = new ShoeHardCodeDatasource();
        shoeList = datasource.readData();
        showList(shoeList);
        /* ChangeListener เกิดเมื่อคลิกในลิสแล้วเปลี่ยนที่ลาเบล */
        shoeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Shoe>() {
            @Override
            public void changed(ObservableValue<? extends Shoe> observable, Shoe oldValue, Shoe newValue) {
                if (newValue == null) {
                    clearShoeInfo();
                    selectedShoe = null;
                } else {
                    showShoeInfo(newValue);
                    selectedShoe = newValue;
                }
                /* newValue คือตัวใหม่ที่ถูกเลือก อีกอันคืออันเก่า */
            }
        });
    }
    private void showList(ShoeList shoeList) {
        shoeListView.getItems().clear();
        shoeListView.getItems().addAll(shoeList.getShoes());
    }

    private void showShoeInfo(Shoe shoe) {
        idLabel.setText(shoe.getId());
        nameLabel.setText(shoe.getName());
        priceLabel.setText(String.format("%.2f", shoe.getPriceInUSD()));
        priceLabel1.setText(String.format("%.2f", shoe.getPriceInTHB()));
        sizeLabel.setText(shoe.getSize());
    }
    private void clearShoeInfo() {
        idLabel.setText("");
        nameLabel.setText("");
        sizeLabel.setText("");
        priceLabel.setText("");
        priceLabel1.setText("");
    }

    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("shoe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onGivePriceButtonClick() {
        if (selectedShoe != null) {
            String priceText = givePriceTextField.getText();
            String errorMessage = "";
            try {
                double price = Double.parseDouble(priceText);
                shoeList.givePriceToId(selectedShoe.getId(), price);
                showShoeInfo(selectedShoe);
                // แปลง scoreText เป็น double ถ้าแปลงไม่ได้ก็ใช้อันล่าง
            } catch (NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    givePriceTextField.setText("");
                }
            }
        } else {
            givePriceTextField.setText("");
            errorLabel.setText("");
        }
    }

}
