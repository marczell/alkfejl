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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcell
 */
public class KeresesController implements Initializable {
    @FXML
    private Button CtrlKereses;
    @FXML
    private TextField SzerzNevKereses;
    @FXML
    private ChoiceBox<?> KozbeszFajtKereses;
    @FXML
    private ChoiceBox<?> SzerzFajtKereses;
    @FXML
    private ChoiceBox<?> CPVKereses;
    @FXML
    private ChoiceBox<?> ProjektKereses;
    @FXML
    private DatePicker SzerzKotTolKereses;
    @FXML
    private DatePicker SzerzLezarTolKereses;
    @FXML
    private ChoiceBox<?> SzerzFelKereses;
    @FXML
    private DatePicker SzerzKotIgKereses;
    @FXML
    private DatePicker SzerzLezarIgKereses;
    @FXML
    private TableColumn<?, ?> SorszamKereses;
    @FXML
    private TableColumn<?, ?> SzerzKotKereses;
    @FXML
    private TableColumn<?, ?> SzerzLezarKereses;
    @FXML
    private TableColumn<?, ?> SzerzertekKereses;
    @FXML
    private Button CtrlKeresesVissza;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
