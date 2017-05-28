package szallasok.viewController;

import javafx.fxml.FXML;
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
        else
        {
            System.out.println("Illetektelen felhasznalo");
        }
    }
    //*********************************
    public void visszaButton()
    {
        mainApp.kezdoViewShow();
    }

}
