package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import szallasok.Main;


/**
 * Created by Stefyy on 2017.05.20..
 */
public class FelvetelLoginViewController {
    @FXML
    private TextField felhasznaloTextField;
    @FXML
    private PasswordField jelszoTextField;

    @FXML
    public void initialize()
    {

    }

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    public void belepesButton()
    {
        if(felhasznaloTextField.getText().equals("admin") && jelszoTextField.getText().equals("admin"))
        {
            mainApp.szallasFelvetelShow();
        }
        else if(felhasznaloTextField.getText().isEmpty() || jelszoTextField.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("A mezok kitoltese kotelezo.\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            mainApp.foglalasLoginViewShow();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Illetektelen felhasznalo!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            mainApp.foglalasLoginViewShow();
        }
    }

    //*********************************
    public void visszaButton()
    {
        mainApp.kezdoViewShow();
    }

}
