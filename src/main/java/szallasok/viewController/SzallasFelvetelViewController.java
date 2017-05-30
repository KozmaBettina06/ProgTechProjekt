package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import szallasok.Main;
import szallasok.SzallasFelvetelService;
import szallasok.model.Szallasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Created by Stefyy on 2017.05.20..
 */
public class SzallasFelvetelViewController {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField szallas_neve_mezo;

    @FXML
    private TextField szallas_cime_mezo;

    @FXML
    private SplitMenuButton szallas_tipusa_menu;

    @FXML
    private SplitMenuButton hazikedvenc_menu;

    @FXML
    private TextArea leiras_mezo;

    @FXML
    private TextField egyes_egyszemelyes_agy;

    @FXML
    private TextField egyes_ketszemelyes_agy;

    @FXML
    private TextField egyes_ferohely;

    @FXML
    private TextField egyes_ado;

    @FXML
    private TextField egyes_ar;

    @FXML
    private TextField kettes_egyszemelyes_agy;

    @FXML
    private TextField kettes_ketszemelyes_agy;

    @FXML
    private TextField kettes_ferohely;

    @FXML
    private TextField kettes_ado;

    @FXML
    private TextField kettes_ar;

    @FXML
    private TextField harmas_egyszemelyes_agy;

    @FXML
    private TextField harmas_ketszemelyes_agy;

    @FXML
    private TextField harmas_ferohely;

    @FXML
    private TextField harmas_ado;

    @FXML
    private TextField harmas_ar;

    private String splitmenuButton1choice = "";
    private String splitmenuButton2choice = "";

    @FXML
    public void initialize() {
        szallas_tipusa_menu.getItems().get(0).setOnAction(event -> {
            splitmenuButton1choice = szallas_tipusa_menu.getItems().get(0).getText();
            szallas_tipusa_menu.setText(szallas_tipusa_menu.getItems().get(0).getText());
        });
        szallas_tipusa_menu.getItems().get(1).setOnAction(event -> {
            splitmenuButton1choice = szallas_tipusa_menu.getItems().get(1).getText();
            szallas_tipusa_menu.setText(szallas_tipusa_menu.getItems().get(1).getText());
        });

        hazikedvenc_menu.getItems().get(0).setOnAction(event -> {
            splitmenuButton2choice = hazikedvenc_menu.getItems().get(0).getText();
            hazikedvenc_menu.setText(hazikedvenc_menu.getItems().get(0).getText());
        });
        hazikedvenc_menu.getItems().get(1).setOnAction(event -> {
            splitmenuButton2choice = hazikedvenc_menu.getItems().get(1).getText();
            hazikedvenc_menu.setText(hazikedvenc_menu.getItems().get(1).getText());
        });
    }

    @FXML
    public void kesz_gomb() {

        if(isValid()) {
            SzallasFelvetelService szallasFelvetel = new SzallasFelvetelService();
            szallasFelvetel.szallasLetrehozas(szallas_neve_mezo.getText(), szallas_cime_mezo.getText(), szallas_tipusa_menu.getText(), hazikedvenc_menu.getText(), leiras_mezo.getText(),
                    Integer.parseInt(egyes_egyszemelyes_agy.getText()), Integer.parseInt(egyes_ketszemelyes_agy.getText()), Integer.parseInt(egyes_ferohely.getText()),
                    Integer.parseInt(egyes_ado.getText()), Integer.parseInt(egyes_ar.getText()),
                    Integer.parseInt(kettes_egyszemelyes_agy.getText()), Integer.parseInt(kettes_ketszemelyes_agy.getText()), Integer.parseInt(kettes_ferohely.getText()),
                    Integer.parseInt(kettes_ado.getText()), Integer.parseInt(kettes_ar.getText()),
                    Integer.parseInt(harmas_egyszemelyes_agy.getText()), Integer.parseInt(harmas_ketszemelyes_agy.getText()), Integer.parseInt(harmas_ferohely.getText()),
                    Integer.parseInt(harmas_ado.getText()), Integer.parseInt(harmas_ar.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Sikeres felvetel.\n");
            alert.setHeaderText("Szallas felvetel");
            alert.showAndWait();
            mainApp.szallasFelvetelShow();
        }
    }

    @FXML
    public void kijelentkezesButton(){
        mainApp.felvetelLoginViewShow();
    }

    private boolean isValid() {
        String hiba = "";
        if (szallas_neve_mezo.getText().trim().isEmpty()) {
            hiba = hiba + "Szallas neve nincs kitoltve.\n";
        }
        if (szallas_cime_mezo.getText().trim().isEmpty()) {
            hiba = hiba + "Szallas cime nincs kitoltve.\n";
        }
        if (leiras_mezo.getText().trim().isEmpty()) {
            hiba = hiba + "Leiras nincs kitoltve.\n";
        }
        if(splitmenuButton1choice.length()== 0)
        {
            hiba=hiba+ "Tipus nincs kivalasztva.\n";
        }
        if(splitmenuButton2choice.length()== 0)
        {
            hiba=hiba+ "Hazikedvenc nincs kivalasztva.\n";
        }
        if (egyes_egyszemelyes_agy.getText().trim().isEmpty()) {
            hiba = hiba + "Egyes szoba egyszemelyes agy nincs kitoltve.\n";
        }
        if (egyes_egyszemelyes_agy.getText().length() > 0) {
            try {
                Integer.parseInt(egyes_egyszemelyes_agy.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Egyes szoba egyszemelyes agy: adjon meg egy szamot\n";
            }
        }
        if (egyes_ketszemelyes_agy.getText().trim().isEmpty()) {
            hiba = hiba + "Egyes szoba ketszemelyes agy nincs kitoltve.\n";
        }
        if (egyes_ketszemelyes_agy.getText().length() > 0) {
            try {
                Integer.parseInt(egyes_ketszemelyes_agy.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Egyes szoba ketszemelyes agy: adjon meg egy szamot\n";
            }
        }
        if (egyes_ferohely.getText().trim().isEmpty()) {
            hiba = hiba + "Egyes szoba ferohely nincs kitoltve.\n";
        }
        if (egyes_ferohely.getText().length() > 0) {
            try {
                Integer.parseInt(egyes_ferohely.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Egyes szoba ferohely: adjon meg egy szamot\n";
            }
        }
        if (egyes_ado.getText().trim().isEmpty()) {
            hiba = hiba + "Egyes szoba ado nincs kitoltve.\n";
        }
        if (egyes_ado.getText().length() > 0) {
            try {
                Integer.parseInt(egyes_ado.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Egyes szoba ado: adjon meg egy szamot\n";
            }
        }
        if (egyes_ar.getText().trim().isEmpty()) {
            hiba = hiba + "Egyes szoba ar nincs kitoltve.\n";
        }
        if (egyes_ar.getText().length() > 0) {
            try {
                Integer.parseInt(egyes_ar.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Egyes szoba ar: adjon meg egy szamot\n";
            }
        }

        if (kettes_egyszemelyes_agy.getText().trim().isEmpty()) {
            hiba = hiba + "Kettes szoba egyszemelyes agy nincs kitoltve.\n";
        }
        if (kettes_egyszemelyes_agy.getText().length() > 0) {
            try {
                Integer.parseInt(kettes_egyszemelyes_agy.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Kettes szoba egyszemelyes agy: adjon meg egy szamot\n";
            }
        }
        if (kettes_ketszemelyes_agy.getText().trim().isEmpty()) {
            hiba = hiba + "Kettes szoba ketszemelyes agy nincs kitoltve.\n";
        }
        if (kettes_ketszemelyes_agy.getText().length() > 0) {
            try {
                Integer.parseInt(kettes_ketszemelyes_agy.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Kettes szoba ketszemelyes agy: adjon meg egy szamot\n";
            }
        }
        if (kettes_ferohely.getText().trim().isEmpty()) {
            hiba = hiba + "Kettes szoba ferohely nincs kitoltve.\n";
        }
        if (kettes_ferohely.getText().length() > 0) {
            try {
                Integer.parseInt(kettes_ferohely.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Kettes szoba ferohely: adjon meg egy szamot\n";
            }
        }
        if (kettes_ado.getText().trim().isEmpty()) {
            hiba = hiba + "Kettes szoba ado nincs kitoltve.\n";
        }
        if (kettes_ado.getText().length() > 0) {
            try {
                Integer.parseInt(kettes_ado.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Kettes szoba ado: adjon meg egy szamot\n";
            }
        }
        if (kettes_ar.getText().trim().isEmpty()) {
            hiba = hiba + "Kettes szoba ar nincs kitoltve.\n";
        }
        if (kettes_ar.getText().length() > 0) {
            try {
                Integer.parseInt(kettes_ar.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Kettes szoba ar: adjon meg egy szamot\n";
            }
        }

        if (harmas_egyszemelyes_agy.getText().trim().isEmpty()) {
            hiba = hiba + "Harmas szoba egyszemelyes agy nincs kitoltve.\n";
        }
        if (harmas_egyszemelyes_agy.getText().length() > 0) {
            try {
                Integer.parseInt(harmas_egyszemelyes_agy.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Harmas szoba egyszemelyes agy: adjon meg egy szamot\n";
            }
        }
        if (harmas_ketszemelyes_agy.getText().trim().isEmpty()) {
            hiba = hiba + "Harmas szoba ketszemelyes agy nincs kitoltve.\n";
        }
        if (harmas_ketszemelyes_agy.getText().length() > 0) {
            try {
                Integer.parseInt(harmas_ketszemelyes_agy.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Harmas szoba ketszemelyes agy: adjon meg egy szamot\n";
            }
        }
        if (harmas_ferohely.getText().trim().isEmpty()) {
            hiba = hiba + "Harmas szoba ferohely nincs kitoltve.\n";
        }
        if (harmas_ferohely.getText().length() > 0) {
            try {
                Integer.parseInt(harmas_ferohely.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Harmas szoba ferohely: adjon meg egy szamot\n";
            }
        }
        if (harmas_ado.getText().trim().isEmpty()) {
            hiba = hiba + "Harmas szoba ado nincs kitoltve.\n";
        }
        if (harmas_ado.getText().length() > 0) {
            try {
                Integer.parseInt(harmas_ado.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Harmas szoba ado: adjon meg egy szamot\n";
            }
        }
        if (harmas_ar.getText().trim().isEmpty()) {
            hiba = hiba + "Harmas szoba ar nincs kitoltve.\n";
        }
        if (harmas_ar.getText().length() > 0) {
            try {
                Integer.parseInt(harmas_ar.getText());
            } catch (NumberFormatException e) {
                hiba = hiba + "Harmas szoba ar: adjon meg egy szamot\n";
            }
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
