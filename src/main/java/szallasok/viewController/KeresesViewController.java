package szallasok.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.hibernate.annotations.SourceType;
import szallasok.*;
import szallasok.model.Foglalasok;
import szallasok.model.Szallasok;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;


/**
 * Created by Stefyy on 2017.05.26..
 */
public class KeresesViewController {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField varos_mezo;

    @FXML
    private SplitMenuButton szallas_tipus_mezo;

    @FXML
    private DatePicker erkezes_menu;

    @FXML
    private DatePicker tavozas_menu;

    @FXML
    private SplitMenuButton hazikedvenc_menu;

    @FXML
    private Label szallas_neve_label;

    @FXML
    private Label szallas_cime_label;

    @FXML
    private Label szallas_tipusa_label;

    @FXML
    private Label hazikedvenc_label;

    @FXML
    private Label leiras_label;

    @FXML
    private Label erkezes_label;

    @FXML
    private Label tavozas_label;

    @FXML
    private Label egyes_foglalt_label;

    @FXML
    private Label egyes_egyszemelyes_label;

    @FXML
    private Label egyes_ketszemelyes_label;

    @FXML
    private Label egyes_ferohely_label;

    @FXML
    private Label egyes_ar_label;

    @FXML
    private Label kettes_foglalt_label;

    @FXML
    private Label kettes_egyszemelyes_label;

    @FXML
    private Label kettes_ketszemelyes_label;

    @FXML
    private Label kettes_ferohely_label;

    @FXML
    private Label kettes_ar_label;

    @FXML
    private Label harmas_foglalt_label;

    @FXML
    private Label harmas_egyszemelyes_label;

    @FXML
    private Label harmas_ketszemelyes_label;

    @FXML
    private Label harmas_ferohely_label;

    @FXML
    private Label harmas_ar_label;

    @FXML
    private TableView<Szallasok> eredmeny_tabla;

    @FXML
    private TableColumn<Szallasok, String> eredmeny_oszlop;

    @FXML
    private Button keresesButtonid;




    private String splitmenuButton1choice = "";
    private String splitmenuButton2choice = "";

    @FXML
    public void initialize() {
        szallas_tipus_mezo.getItems().get(0).setOnAction(event -> {
            splitmenuButton1choice = szallas_tipus_mezo.getItems().get(0).getText();
            szallas_tipus_mezo.setText(szallas_tipus_mezo.getItems().get(0).getText());
        });
        szallas_tipus_mezo.getItems().get(1).setOnAction(event -> {
            splitmenuButton1choice = szallas_tipus_mezo.getItems().get(1).getText();
            szallas_tipus_mezo.setText(szallas_tipus_mezo.getItems().get(1).getText());
        });

        hazikedvenc_menu.getItems().get(0).setOnAction(event -> {
            splitmenuButton2choice = hazikedvenc_menu.getItems().get(0).getText();
            hazikedvenc_menu.setText(hazikedvenc_menu.getItems().get(0).getText());
        });
        hazikedvenc_menu.getItems().get(1).setOnAction(event -> {
            splitmenuButton2choice = hazikedvenc_menu.getItems().get(1).getText();
            hazikedvenc_menu.setText(hazikedvenc_menu.getItems().get(1).getText());
        });

        erkezes_menu.setDayCellFactory(getDayCellFactory());
        tavozas_menu.setDayCellFactory(getDayCellFactory2());

        tavozas_menu.setDisable(true);
        erkezes_menu.setOnAction(event -> {
            if (event != null) {
                tavozas_menu.setDisable(false);
            }
        });

        eredmeny_tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if(newValue==null)
                    {
                        return;
                    }
                    KivalasztottSzallasService szallas = new KivalasztottSzallasService();
                    Szallasok kivSzallas = szallas.szallaskereso(eredmeny_tabla.getSelectionModel().selectedItemProperty().get().getSzallas_neve());
                    SzallasokService.setValasztottSzallas(kivSzallas);
//                    if (newValue == null) {
//                        newValue = oldValue;
//
//                    }
                    szallas_neve_label.setText(newValue.getSzallas_neve());
                    szallas_cime_label.setText(newValue.getSzallas_cime());
                    szallas_tipusa_label.setText(newValue.getSzallas_tipusa());
                    hazikedvenc_label.setText(newValue.getHazikedvenc());
                    leiras_label.setText(newValue.getLeiras());
                    egyes_egyszemelyes_label.setText(Integer.toString(newValue.getEgyes_szoba_egyszemelyes_agy()) + " db");
                    egyes_ketszemelyes_label.setText(Integer.toString(newValue.getEgyes_szoba_ketszemelyes_agy()) + " db");
                    egyes_ferohely_label.setText(Integer.toString(newValue.getEgyes_szoba_ferohely()));
                    egyes_ar_label.setText(Integer.toString(newValue.getEgyes_szoba_ar()) + " Ft/fo/ej");
                    kettes_egyszemelyes_label.setText(Integer.toString(newValue.getKettes_szoba_egyszemelyes_agy()) + " db");
                    kettes_ketszemelyes_label.setText(Integer.toString(newValue.getKettes_szoba_ketszemelyes_agy()) + " db");
                    kettes_ferohely_label.setText(Integer.toString(newValue.getKettes_szoba_ferohely()));
                    kettes_ar_label.setText(Integer.toString(newValue.getKettes_szoba_ar()) + " Ft/fo/ej");
                    harmas_egyszemelyes_label.setText(Integer.toString(newValue.getHarmas_szoba_egyszemelyes_agy()) + " db");
                    harmas_ketszemelyes_label.setText(Integer.toString(newValue.getHarmas_szoba_ketszemelyes_agy()) + " db");
                    harmas_ferohely_label.setText(Integer.toString(newValue.getHarmas_szoba_ferohely()));
                    harmas_ar_label.setText(Integer.toString(newValue.getHarmas_szoba_ar()) + " Ft/fo/ej");
                    erkezes_label.setText(erkezes_menu.getValue().toString());
                    tavozas_label.setText(tavozas_menu.getValue().toString());
                    //foglalt labelek kitoltese
                    // System.out.println( foglaltszallas("1. szoba"));

                    // egyes_foglalt_label.setText("Foglalt");
                    List<Foglalasok> foglalt_eredmeny = foglaltszallas();
                    if(foglalt_eredmeny.isEmpty()){
                        egyes_foglalt_label.setText("Szabad");
                        kettes_foglalt_label.setText("Szabad");
                        harmas_foglalt_label.setText("Szabad");
                    }

                    LocalDate teszt = erkezes_menu.getValue();
                    LocalDate teszt2 = tavozas_menu.getValue();
                    //(teszt.isAfter(datum2)&& teszt2.isAfter(datum2)) || (teszt.isBefore(datum1) && teszt2.isBefore(datum1))
                    for (int i = 0; i < foglalt_eredmeny.size(); i++) {
                        if(foglalt_eredmeny.get(i).getSzoba_szama().equals("1. szoba")){
                            LocalDate datum1 = foglalt_eredmeny.get(i).getErkezes_idopontja();
                            LocalDate datum2 = foglalt_eredmeny.get(i).getTavozas_idopontja();
                            if ((teszt.isAfter(datum2) && teszt2.isAfter(datum2)) || (teszt.isBefore(datum1) && teszt2.isBefore(datum1))) {

                                egyes_foglalt_label.setText("Szabad");

                            } else {
                                egyes_foglalt_label.setText("Foglalt");

                                break;
                            }
                        }
                        if(foglalt_eredmeny.get(i).getSzoba_szama().equals("2. szoba")){
                            LocalDate datum1 = foglalt_eredmeny.get(i).getErkezes_idopontja();
                            LocalDate datum2 = foglalt_eredmeny.get(i).getTavozas_idopontja();
                            if ((teszt.isAfter(datum2) && teszt2.isAfter(datum2)) || (teszt.isBefore(datum1) && teszt2.isBefore(datum1))) {

                                kettes_foglalt_label.setText("Szabad");

                            } else {
                                kettes_foglalt_label.setText("Foglalt");

                                break;
                            }
                        }
                        if(foglalt_eredmeny.get(i).getSzoba_szama().equals("3. szoba")){
                            LocalDate datum1 = foglalt_eredmeny.get(i).getErkezes_idopontja();
                            LocalDate datum2 = foglalt_eredmeny.get(i).getTavozas_idopontja();
                            if ((teszt.isAfter(datum2) && teszt2.isAfter(datum2)) || (teszt.isBefore(datum1) && teszt2.isBefore(datum1))) {

                                harmas_foglalt_label.setText("Szabad");

                            } else {
                                harmas_foglalt_label.setText("Foglalt");

                                break;
                            }
                        }
                    }
                    if(egyes_foglalt_label.getText().isEmpty())
                    {
                        egyes_foglalt_label.setText("Szabad");
                    }else if(kettes_foglalt_label.getText().isEmpty()){
                        kettes_foglalt_label.setText("Szabad");
                    }else if(harmas_foglalt_label.getText().isEmpty()){
                        harmas_foglalt_label.setText("Szabad");
                    }

                }

        );
    }


    private boolean isValid() {
        String hiba = "";
        if (erkezes_menu.getValue() == null || tavozas_menu.getValue() == null) {
            hiba = hiba + "Mindket datum kitoltese kotelezo!\n";
        }else if(tavozas_menu.getValue().isBefore(erkezes_menu.getValue())){
            hiba=hiba + "A tavozas datum korabban van mint az erkezes ideje";
        }
        if (varos_mezo.getText().isEmpty() && szallas_tipus_mezo.getText().equals("Valasszon") && hazikedvenc_menu.getText().equals("Valasszon")) {
            hiba = hiba + "Legalabb egy szuresi feltetel kitoltese szukseges.";
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

    @FXML
    private void keresesButton() {

        if (isValid()) {
            eredmeny_tabla.setItems(keresesUtaniSzallasok());
            eredmeny_oszlop.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSzallas_neve()));
            eredmeny_tabla.getColumns().get(0).setVisible(true);
            keresesButtonid.setDisable(true);
        }

        varos_mezo.setDisable(true);
        szallas_tipus_mezo.setDisable(true);
        hazikedvenc_menu.setDisable(true);
        erkezes_menu.setDisable(true);
        tavozas_menu.setDisable(true);



    }

    public ObservableList<Szallasok> keresesUtaniSzallasok() {
        List<Szallasok> eredmeny = null;
        if (!(varos_mezo.getText().isEmpty()) && szallas_tipus_mezo.getText().equals("Valasszon") && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses(varos_mezo.getText());
            if(eredmeny.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setContentText("Ezzel a varosnevvel nincs szallas regisztralva.\n");
                alert.setHeaderText("Hiba");
                alert.showAndWait();
            }


        } else if (!(varos_mezo.getText().isEmpty()) && !(szallas_tipus_mezo.getText().equals("Valasszon")) && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses2(varos_mezo.getText(), szallas_tipus_mezo.getText());
            if(eredmeny.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setContentText("Nincs a keresesnek megfelelo szallas.\n");
                alert.setHeaderText("Hiba");
                alert.showAndWait();
            }

        } else if (!(varos_mezo.getText().isEmpty()) && !(szallas_tipus_mezo.getText().equals("Valasszon")) && !(hazikedvenc_menu.getText().equals("Valasszon"))) {
            eredmeny = KeresesService.kereses3(varos_mezo.getText(), szallas_tipus_mezo.getText(), hazikedvenc_menu.getText());
            if(eredmeny.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setContentText("Nincs a keresesnek megfelelo szallas.\n");
                alert.setHeaderText("Hiba");
                alert.showAndWait();
            }

        } else if (!(varos_mezo.getText().isEmpty()) && szallas_tipus_mezo.getText().equals("Valasszon") && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses4(varos_mezo.getText(), hazikedvenc_menu.getText());
            if(eredmeny.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setContentText("Nincs a keresesnek megfelelo szallas.\n");
                alert.setHeaderText("Hiba");
                alert.showAndWait();
            }
        } else if (varos_mezo.getText().isEmpty() && !(szallas_tipus_mezo.getText().equals("Valasszon")) && !(hazikedvenc_menu.getText().equals("Valasszon"))) {
            eredmeny = KeresesService.kereses5(szallas_tipus_mezo.getText(), hazikedvenc_menu.getText());
            if(eredmeny.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setContentText("Nincs a keresesnek megfelelo szallas.\n");
                alert.setHeaderText("Hiba");
                alert.showAndWait();
            }
        } else if (varos_mezo.getText().isEmpty() && !(szallas_tipus_mezo.getText().equals("Valasszon")) && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses6(szallas_tipus_mezo.getText());
            if(eredmeny.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setContentText("Nincs a keresesnek megfelelo szallas.\n");
                alert.setHeaderText("Hiba");
                alert.showAndWait();
            }
        } else if (varos_mezo.getText().isEmpty() && szallas_tipus_mezo.getText().equals("Valasszon") && !(hazikedvenc_menu.getText().equals("Valasszon"))) {
            eredmeny = KeresesService.kereses7(hazikedvenc_menu.getText());

        }

        ObservableList eredmeny2 = FXCollections.observableArrayList(eredmeny);

        return eredmeny2;
    }

    @FXML
    private void szerkesztesButton() {

        varos_mezo.setDisable(false);
        szallas_tipus_mezo.setDisable(false);
        hazikedvenc_menu.setDisable(false);
        erkezes_menu.setDisable(false);
        tavozas_menu.setDisable(true);
        szallas_neve_label.setText("");
        szallas_cime_label.setText("");
        szallas_tipusa_label.setText("");
        hazikedvenc_label.setText("");
        leiras_label.setText("");
        egyes_egyszemelyes_label.setText("");
        egyes_ketszemelyes_label.setText("");
        egyes_ferohely_label.setText("");
        egyes_ar_label.setText("");
        kettes_egyszemelyes_label.setText("");
        kettes_ketszemelyes_label.setText("");
        kettes_ferohely_label.setText("");
        kettes_ar_label.setText("");
        harmas_egyszemelyes_label.setText("");
        harmas_ketszemelyes_label.setText("");
        harmas_ferohely_label.setText("");
        harmas_ar_label.setText("");
        erkezes_label.setText("");
        tavozas_label.setText("");
        egyes_foglalt_label.setText("");
        kettes_foglalt_label.setText("");
        harmas_foglalt_label.setText("");
        eredmeny_tabla.getColumns().get(0).setVisible(false);
        keresesButtonid.setDisable(false);

    }

    public boolean isValid2(){
        if(eredmeny_tabla.getSelectionModel().selectedItemProperty().isNull().get())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Foglalashoz jeloljon ki egy szallast.\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public List<Foglalasok> foglaltszallas(){
        FoglaltFigyeloService foglaltszoba = new FoglaltFigyeloService();
        List<Foglalasok> foglaltszoba_eredmeny = foglaltszoba.foglaltkereso(szallas_neve_label.getText());
       // System.out.println(szallas_neve_label.getText());
        //System.out.println(szobaszam);
        return foglaltszoba_eredmeny;
    }

    @FXML
    private void egyesFoglalasButton() {
        //ha nincs kivalasztva szallas ne lehessen foglalni
        if(egyes_foglalt_label.getText().equals("Foglalt"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Ez a szoba foglalt!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return;
        }
        if(egyes_foglalt_label.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Valasszon ki szallast!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return;
        }
        if(isValid2())
        {
            SzallasokService.getValasztottSzallas().setEgyes(true);
            SzallasokService.getValasztottSzallas().setErkezes(erkezes_menu.getValue());
            SzallasokService.getValasztottSzallas().setTavozas(tavozas_menu.getValue());
            SzallasokService.getValasztottSzallas().setFerohely(Integer.parseInt(egyes_ferohely_label.getText()));
            mainApp.foglalasViewShow();
        }

    }

    @FXML
    private void kettesFoglalasButton() {
        //ha nincs kivalasztva szallas ne lehessen foglalni
        if(kettes_foglalt_label.getText().equals("Foglalt"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Ez a szoba foglalt!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return;
        }
        if(kettes_foglalt_label.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Valasszon ki szallast!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return;
        }
        if(isValid2())
        {
            SzallasokService.getValasztottSzallas().setKettes(true);
            SzallasokService.getValasztottSzallas().setErkezes(erkezes_menu.getValue());
            SzallasokService.getValasztottSzallas().setTavozas(tavozas_menu.getValue());
            SzallasokService.getValasztottSzallas().setFerohely(Integer.parseInt(kettes_ferohely_label.getText()));
            mainApp.foglalasViewShow();
        }
    }

    @FXML
    private void harmasFoglalasButton() {
        //ha nincs kivalasztva szallas ne lehessen foglalni
        if(harmas_foglalt_label.getText().equals("Foglalt"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Ez a szoba foglalt!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return;
        }
        if(harmas_foglalt_label.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setContentText("Valasszon ki szallast!\n");
            alert.setHeaderText("Hiba");
            alert.showAndWait();
            return;
        }
        if(isValid2())
        {
            SzallasokService.getValasztottSzallas().setHarmas(true);
            SzallasokService.getValasztottSzallas().setErkezes(erkezes_menu.getValue());
            SzallasokService.getValasztottSzallas().setTavozas(tavozas_menu.getValue());
            SzallasokService.getValasztottSzallas().setFerohely(Integer.parseInt(harmas_ferohely_label.getText()));
            mainApp.foglalasViewShow();
        }
    }

    @FXML
    private void kijelentkezesButton() {
        mainApp.foglalasLoginViewShow();
    }


    private Callback<DatePicker, DateCell> getDayCellFactory() {

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {

            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        return dayCellFactory;
    }

    private Callback<DatePicker, DateCell> getDayCellFactory2() {

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {

            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(erkezes_menu.getValue().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        return dayCellFactory;
    }
}
