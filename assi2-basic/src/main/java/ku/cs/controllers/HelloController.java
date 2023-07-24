package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class HelloController {

    @FXML
    protected void onHelloButtonClick() {
        try {
            FXRouter.goTo("shoe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("shoe-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}