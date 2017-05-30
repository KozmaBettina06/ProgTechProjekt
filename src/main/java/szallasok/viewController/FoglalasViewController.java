package szallasok.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import szallasok.*;
import szallasok.model.Szallasok;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * Created by Stefyy on 2017.05.29..
 */
public class FoglalasViewController {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField foglalo_neve;

    @FXML
    private TextField szallas_neve;

    @FXML
    private Label erkezes_napja;

    @FXML
    private Label tavozas_napja;

    @FXML
    private TextField kivalasztott_szoba;

    @FXML
    private TextField erkezok_szama;

    @FXML
    private TextField ejszakak_szama;

    @FXML
    private Label ado_label;

    @FXML
    private Label szoba_ar_label;

    @FXML
    private Label fizetendo_label;

    @FXML
    private Label osszes_ado_label;

    @FXML
    private Label osszes_szoba_ar_label;

    @FXML
    private void nezzukazarattButton(){
        if(isValid()){
            if (SzallasokService.getValasztottSzallas().isEgyes()) {

                szoba_ar_label.setText(Integer.toString(SzallasokService.getValasztottSzallas().getEgyes_szoba_ar()));
                ado_label.setText(Integer.toString(SzallasokService.getValasztottSzallas().getEgyes_szoba_ado()));
                osszes_ado_label.setText(Long.toString(SzamolasService.osszesAdo(Integer.parseInt(erkezok_szama.getText()),Integer.parseInt(ado_label.getText()),SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
                osszes_szoba_ar_label.setText(Long.toString(SzamolasService.osszesSzobaar(Integer.parseInt(erkezok_szama.getText()),Integer.parseInt(szoba_ar_label.getText()),SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
                fizetendo_label.setText(Long.toString(SzamolasService.fizetendo(Integer.parseInt(erkezok_szama.getText()),Integer.parseInt(ado_label.getText()),Integer.parseInt(erkezok_szama.getText()),Integer.parseInt(szoba_ar_label.getText()),SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
            }else if(SzallasokService.getValasztottSzallas().isKettes()){
                szoba_ar_label.setText(Integer.toString(SzallasokService.getValasztottSzallas().getKettes_szoba_ar()) );
                ado_label.setText(Integer.toString(SzallasokService.getValasztottSzallas().getKettes_szoba_ado()) );
                osszes_ado_label.setText(Long.toString(SzamolasService.osszesAdo(Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(ado_label.getText()), SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
                osszes_szoba_ar_label.setText(Long.toString(SzamolasService.osszesSzobaar(Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(szoba_ar_label.getText()), SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
                fizetendo_label.setText(Long.toString(SzamolasService.fizetendo(Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(ado_label.getText()), Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(szoba_ar_label.getText()), SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
            } else if(SzallasokService.getValasztottSzallas().isHarmas()){
                szoba_ar_label.setText(Integer.toString(SzallasokService.getValasztottSzallas().getHarmas_szoba_ar()) );
                ado_label.setText(Integer.toString(SzallasokService.getValasztottSzallas().getHarmas_szoba_ado()) );
                osszes_ado_label.setText(Long.toString(SzamolasService.osszesAdo(Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(ado_label.getText()), SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
                osszes_szoba_ar_label.setText(Long.toString(SzamolasService.osszesSzobaar(Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(szoba_ar_label.getText()), SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
                fizetendo_label.setText(Long.toString(SzamolasService.fizetendo(Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(ado_label.getText()), Integer.parseInt(erkezok_szama.getText()), Integer.parseInt(szoba_ar_label.getText()), SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
            }


        }

    }

    @FXML
    private void lefoglalomButton(){
        if(isValid2()){
            FoglalasService szallasfoglalas= new FoglalasService();
            szallasfoglalas.szallasFoglalas(foglalo_neve.getText(),szallas_neve.getText(),kivalasztott_szoba.getText(),
                    SzallasokService.getValasztottSzallas().getErkezes(),SzallasokService.getValasztottSzallas().getTavozas(),Integer.parseInt(ejszakak_szama.getText()),
                    Integer.parseInt(erkezok_szama.getText()),Integer.parseInt(fizetendo_label.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Sikeres foglalas.\n");
            alert.setHeaderText("Szallas felvetel");
            alert.showAndWait();
            mainApp.keresesViewShow();
        }
    }

    @FXML
    private void visszaButton(){
        mainApp.keresesViewShow();
    }

    @FXML
    public void initialize(){
        foglalo_neve.setText(BelepettService.getBelepett().getTeljesnev());
        szallas_neve.setText(SzallasokService.getValasztottSzallas().getSzallas_neve());
        erkezes_napja.setText(SzallasokService.getValasztottSzallas().getErkezes().toString());
        tavozas_napja.setText(SzallasokService.getValasztottSzallas().getTavozas().toString());
        ejszakak_szama.setText(Long.toString(SzamolasService.eltoltottNapokSzama(SzallasokService.getValasztottSzallas().getErkezes(), SzallasokService.getValasztottSzallas().getTavozas())));
        if(SzallasokService.getValasztottSzallas().isEgyes())
        {
            kivalasztott_szoba.setText("1. szoba");
        }else if(SzallasokService.getValasztottSzallas().isKettes()){
            kivalasztott_szoba.setText("2. szoba");
        }else if(SzallasokService.getValasztottSzallas().isHarmas()){
            kivalasztott_szoba.setText("3. szoba");
        }
    }

    public boolean isValid(){
        String hiba="";
        if(erkezok_szama.getText().isEmpty()){
            hiba=hiba+"Toltse ki az erkezok szamat.\n";
        }else if(Integer.parseInt(erkezok_szama.getText()) > SzallasokService.getValasztottSzallas().getFerohely()){

            hiba= hiba +"A szoba ferohelye:" + SzallasokService.getValasztottSzallas().getFerohely() + "\n";

        }

        if(hiba.length() >0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText(hiba);
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return false;
        }else{
            return true;
        }
    }
    public boolean isValid2(){
        if (fizetendo_label.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Elobb nezze meg az arakat!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return false;
        }else{
            return true;
        }

    }

//    public long eltoltottNapokSzama(LocalDate date1, LocalDate date2){
//        LocalDate erkezesNapja= date1;
//        LocalDate tavozasNapja= date2;
//        long napok=erkezesNapja.until(tavozasNapja, ChronoUnit.DAYS);
//        return napok;
//    }
//
//    public long osszesAdo(){
//
//        int fo = Integer.parseInt(erkezok_szama.getText());
//        int ado= Integer.parseInt(ado_label.getText());
//        return (fo*ado)*eltoltottNapokSzama(SzallasokService.getValasztottSzallas().getErkezes(),SzallasokService.getValasztottSzallas().getTavozas());
//    }
//    public long osszesSzobaar(){
//
//        int fo = Integer.parseInt(erkezok_szama.getText());
//        int ar = Integer.parseInt(szoba_ar_label.getText());
//        return (fo*ar)*eltoltottNapokSzama(SzallasokService.getValasztottSzallas().getErkezes(),SzallasokService.getValasztottSzallas().getTavozas());
//    }
//    public long fizetendo(){
//        return osszesAdo()+osszesSzobaar();
//    }
}
