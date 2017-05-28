package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import szallasok.BelepesService;
import szallasok.Main;
import szallasok.model.Felhasznalok;

import java.util.List;

/**
 * Created by Stefyy on 2017.05.24..
 */

//*********************************
public class FoglalasLoginViewController {

    @FXML
    private TextField foglaloFelhasznaloTextfield;

    @FXML
    private PasswordField foglaloPassfield;

    @FXML
    public void initialize()
    {

    }

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void regButton()
    {
        mainApp.foglalasRegViewShow();
    }
    @FXML
    public void visszaButton()
    {
        mainApp.kezdoViewShow();
    }
    @FXML
    public void belepesButton()
    {
        List<Felhasznalok> eredmeny = BelepesService.felhasznaloLista();
        eredmeny.stream().forEach(System.out::println);
        mainApp.keresesViewShow();
    }
}
