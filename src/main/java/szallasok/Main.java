package szallasok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import szallasok.viewController.*;

import java.io.IOException;

/**
 * Created by Stefyy on 2017.05.20..
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        kezdoViewShow();
    }

    public void initRootLayout()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootLayout.fxml"));
            rootLayout =(BorderPane) loader.load();
            primaryStage.setScene(new Scene(rootLayout));
            primaryStage.show();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void kezdoViewShow()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/kezdo.fxml"));
            AnchorPane kezdoView =(AnchorPane) loader.load();
            rootLayout.setCenter(kezdoView);
            KezdoViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void felvetelLoginViewShow(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/felvetelLogin.fxml"));
            AnchorPane felvetelLogin =(AnchorPane) loader.load();
            rootLayout.setCenter(felvetelLogin);
            FelvetelLoginViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void szallasFelvetelShow()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/szallasFelvetel.fxml"));
            AnchorPane szallasFelvetel =(AnchorPane) loader.load();
            rootLayout.setCenter(szallasFelvetel);
            primaryStage.setMaximized(true);
            SzallasFelvetelViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //*******************
    public void foglalasLoginViewShow()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/foglaloLogin.fxml"));
            AnchorPane szallasFoglalas =(AnchorPane) loader.load();
            rootLayout.setCenter(szallasFoglalas);
           // primaryStage.setMaximized(true);
            FoglalasLoginViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void foglalasRegViewShow()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/foglaloReg.fxml"));
            AnchorPane foglaloReg =(AnchorPane) loader.load();
            rootLayout.setCenter(foglaloReg);
          //  primaryStage.setMaximized(true);
            FoglalasRegViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void keresesViewShow()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/kereses.fxml"));
            AnchorPane kereses =(AnchorPane) loader.load();
            rootLayout.setCenter(kereses);
            primaryStage.setMaximized(true);
            KeresesViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void foglalasViewShow()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/foglalas.fxml"));
            AnchorPane foglalas =(AnchorPane) loader.load();
            rootLayout.setCenter(foglalas);
            primaryStage.setMaximized(true);
            FoglalasViewController controller = loader.getController();
            controller.setMainApp(this);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
