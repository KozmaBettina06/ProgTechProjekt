package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import szallasok.FoglaloRegService;
import szallasok.Main;


import java.awt.*;


/**
 * Created by Stefyy on 2017.05.24..
 */

//*******************************
public class FoglalasRegViewController {
    @FXML
    private TextField regFelhasznalonev;
    @FXML
    private TextField regTeljesNev;
    @FXML
    private PasswordField regPass;
    @FXML
    private PasswordField regPassUjra;


    @FXML
    public void initialize()
    {

    }
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    public void visszaButton()
    {
        mainApp.foglalasLoginViewShow();
    }
    @FXML
    public void regButton()
    {
        if(isValid())
        {
            FoglaloRegService foglaloRegisztracio = new FoglaloRegService();
            foglaloRegisztracio.regisztracio(regFelhasznalonev.getText(),regTeljesNev.getText(),regPass.getText(),regPassUjra.getText());
        }
        //ki kell jelentkeztetni m�g!!!!!!!!!!!!!!!!!
    }

    private boolean isValid()
    {
        String hiba="";
        if (regFelhasznalonev.getText().trim().isEmpty()) {
            hiba = hiba + "Felhasznalonev nincs kitoltve.\n";
        }
        if(regTeljesNev.getText().trim().isEmpty()){
            hiba = hiba + "Teljes nev nincs kitoltve.\n";
        }
        if(regPass.getText().trim().isEmpty()){
            hiba=hiba + "Adjon meg jelszot.\n";
        }
        if(regPassUjra.getText().trim().isEmpty()){
            hiba= hiba + "Ismetelje meg a jelszot.\n";
        }
        if(!(regPass.getText().equals(regPassUjra.getText()))){
            hiba=hiba + "A ket jelszo nem egyezik meg.\n";
        }

        if (hiba.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText(hiba);
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }
}
