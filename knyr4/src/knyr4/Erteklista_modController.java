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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcell
 */
public class Erteklista_modController implements Initializable {
    @FXML
    private Button CtrlErtekTorles;
    @FXML
    private TextField UjErtek;
    @FXML
    private Button CtrlErteklistaVissza;
    @FXML
    private Button CtrlUjErtekMentes;
    @FXML
    private ChoiceBox<?> ErtekLista1;
    @FXML
    private ChoiceBox<?> ErtekLista2;
    @FXML
    private ChoiceBox<?> OsszesErtek;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
