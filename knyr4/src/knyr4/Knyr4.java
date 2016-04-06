package knyr4;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Marcell
 */
public class Knyr4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fomenu.fxml"));

        Scene scene = new Scene(root);
        Application.setUserAgentStylesheet(null);
        StyleManager.getInstance().addUserAgentStylesheet("knyr4/alkfejl.css");
        stage.setScene(scene);    
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
