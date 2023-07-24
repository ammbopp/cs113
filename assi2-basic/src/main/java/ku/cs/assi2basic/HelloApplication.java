package ku.cs.assi2basic;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Hello World: Welcome to ShoesList");
        configRoute();
        FXRouter.goTo("shoe-list");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "profile.fxml");
        FXRouter.when("shoe-list", viewPath + "shoe-list.fxml");
        FXRouter.when("shoe", viewPath + "shoe.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}