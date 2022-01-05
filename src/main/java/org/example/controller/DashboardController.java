package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.example.App;

import java.io.IOException;
import java.net.URL;

public class DashboardController {

    private final static String DASHBOARD_ROOT = "dashboard";

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private void handleSwitchView(ActionEvent e) {
        String view = (String) ((Node)e.getSource()).getUserData();
        loadViewByFXML(App.class.getResource(DASHBOARD_ROOT + view));
    }

    private void loadViewByFXML(URL url) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            mainBorderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
