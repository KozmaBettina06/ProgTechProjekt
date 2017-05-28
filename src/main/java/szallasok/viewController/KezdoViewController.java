package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import szallasok.Main;

/**
 * Created by Stefyy on 2017.05.20..
 */
public class KezdoViewController {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void szallasFelvetelButton()
    {
        mainApp.felvetelLoginViewShow();
    }

    //***********************
    @FXML
    private void szallasFoglalasButton()
    {
        mainApp.foglalasLoginViewShow();
    }
}
