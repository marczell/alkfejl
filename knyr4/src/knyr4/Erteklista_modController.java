/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyr4;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML
    private Label uzenet;
    
    private Kapcsolat kapcsolat = new Kapcsolat();
    
    String tabla = new String();
    String oszlop = new String();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
               
        List<String> list = new ArrayList<>();// ezt a feltöltési módszert ComboBoxhoz ajánlották, de hátha itt is működik
        list.add("CPV kód");
        list.add("Közbeszerzési eljárás fajta");
        list.add("Projekt");
        list.add("Szerződés fajta");
        ObservableList obList = FXCollections.observableList(list);
        ErtekLista1.getItems().clear();
        ErtekLista1.setItems(obList);
        ErtekLista2.getItems().clear();
        ErtekLista2.setItems(obList);
        
    } 
    
    private void listaKivalasztasAction(ActionEvent event) {
        //a értéklista kiválasztása
        Object kivalasztott = ErtekLista2.getSelectionModel().getSelectedItem();
        List<String> list2 = new ArrayList<>();
        String sql= new String();
        
        if (kivalasztott.toString()== "CPV kód"){
            sql = "SELECT CPVKOD FROM CPVKODOK WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try {
                tabla = "CPVKODOK";
                oszlop = "CPVKOD";
                ResultSet rs = kapcsolat.adatbazisReport(sql); 
                while (rs.next()) {
                    String s = rs.getString("CPVKOD");
                    list2.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Erteklista_modController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        } else if (kivalasztott.toString()== "Közbeszerzési eljárás fajta"){
            sql = "SELECT KOZBESZERZESIELJARASFAJTAI FROM KOZBESZERZESIELJARASFAJTAI WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try { 
                tabla = "KOZBESZERZESIELJARASFAJTAI";
                oszlop = "KOZBESZERZESIELJARASFAJTAI";
                ResultSet rs = kapcsolat.adatbazisReport(sql); 
                while (rs.next()) {
                    String s = rs.getString("KOZBESZERZESIELJARASFAJTAI");
                    list2.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Erteklista_modController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        } else if (kivalasztott.toString()== "Projekt"){
            sql = "SELECT PROJEKT FROM PROJEKTEK WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try {
                tabla = "PROJEKTEK";
                 oszlop = "PROJEKT";
                ResultSet rs = kapcsolat.adatbazisReport(sql); 
                while (rs.next()) {
                    String s = rs.getString("PROJEKT");
                    list2.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Erteklista_modController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        } else {
            sql = "SELECT SZERZODESFAJTA FROM SZERZODESFAJTAI WHERE LATHATO=TRUE";
           try {
                tabla = "SZERZODESFAJTAI";
                oszlop = "SZERZODESFAJTA";
                ResultSet rs = kapcsolat.adatbazisReport(sql); 
                while (rs.next()) {
                    String s = rs.getString("SZERZODESFAJTA");
                    list2.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Erteklista_modController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            } 
            
        }
        ObservableList obList2 = FXCollections.observableList(list2);
        OsszesErtek.getItems().clear();
        OsszesErtek.setItems(obList2);
        }
    @FXML
     private void ertekTorlesAction(ActionEvent event) {
        //a érték lathato paraméterének false-ra állítása
        Object kivalasztottErtek = OsszesErtek.getSelectionModel().getSelectedItem();
        String sql = "UPDATE "+tabla+" SET LATHATO=FALSE WHERE "+oszlop+" = "+kivalasztottErtek.toString();
        try {
                kapcsolat.adatbazisbaInsertalas(sql);
                uzenet.setText("Sikeres mentése a " + kivalasztottErtek.toString());
            } catch (SQLException ex) {
                Logger.getLogger(Erteklista_modController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba a mentés során!");
            } finally {
                kapcsolat.closeConnection();
            }
    }
    @FXML
     private void ujErtekMentes(ActionEvent event) {
        //új érték mentése
        Object kivalasztott = ErtekLista1.getSelectionModel().getSelectedItem();
        
        if (kivalasztott.toString()== "CPV kód" && UjErtek.getText().length() <= 150){
            tabla="CPVKODOK";
            oszlop = "CPVKOD";
        } else if (kivalasztott.toString()== "Közbeszerzési eljárás fajta"){
            tabla = "KOZBESZERZESIELJARASFAJTAI";
            oszlop = "KOZBESZERZESIELJARASFAJTAI";
        } else if (kivalasztott.toString()== "Projekt"){
            tabla = "PROJEKTEK";
            oszlop = "PROJEKT";
        } else {
            tabla = "SZERZODESFAJTAI";
            oszlop = "SZERZODESFAJTA";   
        } 
        String sql = "INSERT INTO "+tabla+" ("+oszlop+",LATHATO) VALUES ('"+UjErtek.getText()+"', TRUE)";
    
        try {
                kapcsolat.adatbazisbaInsertalas(sql);
                uzenet.setText("Sikeres mentése a " + UjErtek.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Erteklista_modController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba a mentés során!");
            } finally {
                kapcsolat.closeConnection();
            }
     }
    
     @FXML
    private void visszaAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) CtrlErteklistaVissza.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("fomenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }   

    @FXML
    private void listaKivalasztasAction(ContextMenuEvent event) {
    }
     }
