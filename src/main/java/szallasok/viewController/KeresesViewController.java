package szallasok.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import szallasok.KeresesService;
import szallasok.Main;
import szallasok.model.Szallasok;

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
    private TableColumn<Szallasok,String> eredmeny_oszlop;

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
            if(event != null){
                tavozas_menu.setDisable(false);
            }
        });

    }
    private boolean isValid(){
        String hiba= "";
        if(erkezes_menu.getValue()==null || tavozas_menu.getValue()==null)
        {
            hiba=hiba+"Mindket datum kitoltese kotelezo!\n";
        }
        if(varos_mezo.getText().isEmpty() && szallas_tipus_mezo.getText().equals("Valasszon") && hazikedvenc_menu.getText().equals("Valasszon"))
        {
            hiba=hiba+"Legalabb egy szuresi feltetel kitoltese szukseges.";
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

//        List<Szallasok> teszt= KeresesService.kereses("Eger");
//        teszt.stream().forEach(System.out::println);
//        List<Szallasok> teszt2= KeresesService.kereses2("Debrecen", "Apartman");
//        teszt2.stream().forEach(System.out::println);
//        List<Szallasok> teszt3= KeresesService.kereses3("Eger", "Apartman", "Nem");
//        teszt3.stream().forEach(System.out::println);
        if(isValid())
        {
            eredmeny_tabla.setItems(keresesUtaniSzallasok());
            eredmeny_oszlop.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getSzallas_neve()));
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
            eredmeny.stream().forEach(System.out::println);

        } else if (!(varos_mezo.getText().isEmpty()) && !(szallas_tipus_mezo.getText().equals("Valasszon")) && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses2(varos_mezo.getText(), szallas_tipus_mezo.getText());
            eredmeny.stream().forEach(System.out::println);

        } else if (!(varos_mezo.getText().isEmpty()) && !(szallas_tipus_mezo.getText().equals("Valasszon")) && !(hazikedvenc_menu.getText().equals("Valasszon"))) {
            eredmeny = KeresesService.kereses3(varos_mezo.getText(), szallas_tipus_mezo.getText(), hazikedvenc_menu.getText());
            eredmeny.stream().forEach(System.out::println);

        } else if (!(varos_mezo.getText().isEmpty()) && szallas_tipus_mezo.getText().equals("Valasszon") && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses4(varos_mezo.getText(), hazikedvenc_menu.getText());
            eredmeny.stream().forEach(System.out::println);

        } else if (varos_mezo.getText().isEmpty() && !(szallas_tipus_mezo.getText().equals("Valasszon")) && !(hazikedvenc_menu.getText().equals("Valasszon"))) {
            eredmeny = KeresesService.kereses5(szallas_tipus_mezo.getText(), hazikedvenc_menu.getText());
            eredmeny.stream().forEach(System.out::println);

        } else if (varos_mezo.getText().isEmpty() && !(szallas_tipus_mezo.getText().equals("Valasszon")) && hazikedvenc_menu.getText().equals("Valasszon")) {
            eredmeny = KeresesService.kereses6(szallas_tipus_mezo.getText());
            eredmeny.stream().forEach(System.out::println);

        } else if (varos_mezo.getText().isEmpty() && szallas_tipus_mezo.getText().equals("Valasszon") && !(hazikedvenc_menu.getText().equals("Valasszon"))) {
            eredmeny = KeresesService.kereses7(hazikedvenc_menu.getText());
            eredmeny.stream().forEach(System.out::println);

        }


//        System.out.println(szallas_tipus_mezo.getText());
//        if(szallas_tipus_mezo.getText().equals("Valasszon"))
//        {
//            System.out.println("hello");
//        }

        //tegye használhatatlanná a fieldeket
        //hiba ha a datum nincs kitoltve
        //irja ki ha nincs a beirt varosban hotel felveve
        //erkezes idopontja es tavozas idopontja a mai napnal regebbi
        ObservableList eredmeny2 = FXCollections.observableArrayList(eredmeny);

        return eredmeny2;
    }

    @FXML
    private void szerkesztesButton() {
        //tegye ujra szerkeszthetove a fieldeket, ne torolje ki az elozot
        varos_mezo.setDisable(false);
        szallas_tipus_mezo.setDisable(false);
        hazikedvenc_menu.setDisable(false);
        erkezes_menu.setDisable(false);
        tavozas_menu.setDisable(false);
    }

    @FXML
    private void foglalasButton() {
        //uj view, ahol beallithatja, hogy hanyan mennek stb

    }

    @FXML
    private void foglalasaimButton() {
        //kiszedi a nevere szolo foglalasokat es kilistazza
    }

    @FXML
    private void kijelentkezesButton() {
        //kijelentkeztet
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
