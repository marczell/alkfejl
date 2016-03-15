/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyr4;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcell
 */
public class SzerzrogzitesController implements Initializable {
    @FXML
    private Button CtrlSzerzMentes;
    @FXML
    private TextField SzerzertekSzerz;
    @FXML
    private ChoiceBox<?> KozbeszfajtSzerz;
    @FXML
    private ChoiceBox<?> SzerzFajtSzerz;
    @FXML
    private ChoiceBox<?> CpvSzerz;
    @FXML
    private ChoiceBox<?> ProjektSzerz;
    @FXML
    private DatePicker SzerzkotSzerz;
    @FXML
    private DatePicker SzerzlezarSzerz;
    @FXML
    private ChoiceBox<?> SzerzfelSzerz;
    @FXML
    private Label Sorszam;
    @FXML
    private Button CtrlSzerzVissza;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
