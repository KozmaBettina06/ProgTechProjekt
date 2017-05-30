package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import szallasok.BelepesService;
import szallasok.BelepettService;
import szallasok.FelhasznalokService;
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
    public void initialize() {

    }

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void regButton() {
        mainApp.foglalasRegViewShow();
    }

    @FXML
    public void visszaButton() {
        mainApp.kezdoViewShow();
    }

    @FXML
    public void belepesButton() {
        if (isValid()) {

            mainApp.keresesViewShow();
        }
    }

    public boolean isValid() {

        if (!(foglaloFelhasznaloTextfield.getText().isEmpty()) && !(foglaloPassfield.getText().isEmpty())) {
            List<String> eredmeny = BelepesService.felhasznaloLista();

            for (int i = 0; i < eredmeny.size(); i++) {
                if (foglaloFelhasznaloTextfield.getText().equals(eredmeny.get(i))) {
                    String jelszo = BelepesService.jelszoLista(foglaloFelhasznaloTextfield.getText());
                    if ((foglaloPassfield.getText().equals(jelszo))) {
                        FelhasznalokService felhasznalo = new FelhasznalokService();
                        Felhasznalok beFelh = felhasznalo.felhasznalokereso(foglaloFelhasznaloTextfield.getText());
                        BelepettService.setBelepett(beFelh);
                        return true;
                    }
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(mainApp.getPrimaryStage());
                    alert.setContentText("Rossz jelszo.\n");
                    alert.setHeaderText("Hiba");
                    alert.showAndWait();
                    return false;
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Ilyen felhasznalo nincs regisztralva.\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return false;
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setContentText("Mindket mezot ki kell tolteni.\n");
        alert.setHeaderText("Hiba");
        alert.showAndWait();
        return false;
    }
}