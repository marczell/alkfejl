/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyr4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Marcell
 */
public class Projekt_egybController implements Initializable {
    @FXML
    private Button CtrlPrEgybe;
    @FXML
    private DatePicker PrEgybeTol;
    @FXML
    private DatePicker PrEgybeIg;
    @FXML
    private TableView<?> TablePrEgybe;
    @FXML
    private TableColumn<?, ?> PrEgybeProjekt;
    @FXML
    private TableColumn<?, ?> PrEgybeOsszeg;
    @FXML
    private Button CtrlPrEgybeVissza;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
