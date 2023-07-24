module ku.cs.assi2basic {
    requires javafx.controls;
    requires javafx.fxml;


    opens ku.cs.assi2basic to javafx.fxml;
    exports ku.cs.assi2basic;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
}