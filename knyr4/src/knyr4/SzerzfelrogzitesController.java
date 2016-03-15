/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyr4;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcell
 */
public class SzerzfelrogzitesController implements Initializable {
    @FXML
    private Button CtrlSzerzfelMentes;
    @FXML
    private TextField SzerzFel;
    @FXML
    private TextField Varos;
    @FXML
    private TextField Irszam;
    @FXML
    private TextField Koterulet;
    @FXML
    private TextField Hazszam;
    @FXML
    private TextField Telszam;
    @FXML
    private TextField Faxszam;
    @FXML
    private TextField Email;
    @FXML
    private TextField Cegjszam;
    @FXML
    private TextField Adoszam;
    @FXML
    private TextField Kapcstartnev;
    @FXML
    private TextField Kapcstarttelszam;
    @FXML
    private TextField Kapcstartemail;
    @FXML
    private Button CtrlSzerzfelVissza;

    private Kapcsolat kapcsolat = new Kapcsolat();
    
    @FXML
    private Label uzenet;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mentesAction(ActionEvent event) {
        //a szerződő fél adatainak rögzítése
        String sql = "INSERT INTO `szerzodo_fel`(`szerzodofel`, `szekhely-varos`, `szekhely-iranyitoszam`, `szekhely-kozterulet`, \n"
                + "`szekhely-hazszam`, `telefonszam`, `faxszam`, `e-mail`, `cegjegyzekszam`, `adoszam`, `kapcsolattarto-neve`,\n"
                + "`kapcsolattarto-tel`, `kapcsolattarto-email`) \n"
                + "VALUES ('"+SzerzFel.getText()+"','"+Varos.getText()+"',"+Irszam.getText()+",'"+Koterulet.getText()+"',"
                + Hazszam.getText()+",'"+Telszam.getText()+"','"+Faxszam.getText()+"','"+Email.getText()+"','"+Cegjszam.getText()+"','"+Adoszam.getText()+"','"+Kapcstartnev.getText()+"','"
                +Kapcstarttelszam.getText()+"','"+Kapcstartemail.getText()+"')";
        System.out.println(sql);
        try {
            kapcsolat.adatbazisbaInsertalas(sql);
            uzenet.setText("Sikeres mentése a "+SzerzFel.getText());
        } catch (SQLException ex) {
            Logger.getLogger(SzerzfelrogzitesController.class.getName()).log(Level.SEVERE, null, ex);
            uzenet.setText("Hiba a mentés során!");
        } finally {
            kapcsolat.closeConnection();
        }
        
    }

    @FXML
    private void visszaAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) CtrlSzerzfelVissza.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("fomenu.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
}
