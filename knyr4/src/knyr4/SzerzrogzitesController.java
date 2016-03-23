/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyr4;

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
    @FXML
    private Label uzenet;
    
    private Kapcsolat kapcsolat = new Kapcsolat();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> listKej = new ArrayList<>();
        List<String> listKejId = new ArrayList<>();
        String sql1 = "SELECT KOZBESZERZESIELJARASFAJTAI, KEJID FROM KOZBESZERZESIELJARASFAJTAI WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try {
                ResultSet rs = kapcsolat.adatbazisReport(sql1); 
                while (rs.next()) {
                    String s = rs.getString("KEJID");
                    String t = rs.getString("KOZBESZERZESIELJARASFAJTAI");
                    listKejId.add(s);
                    listKej.add(t);
                }
                ObservableList obListKej = FXCollections.observableList(listKej);
                KozbeszfajtSzerz.getItems().clear();
                KozbeszfajtSzerz.setItems(obListKej);
            } catch (SQLException ex) {
                Logger.getLogger(SzerzrogzitesController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        List<String> listSzerzF = new ArrayList<>();
        List<String> listSzerzFId = new ArrayList<>();
        String sql2 = "SELECT SZERZODESFAJTA, SZERZODESFAJTAID FROM SZERZODESFAJTAI WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try {
                ResultSet rs = kapcsolat.adatbazisReport(sql2); 
                while (rs.next()) {
                    String s = rs.getString("SZERZODESFAJTAID");
                    String t = rs.getString("SZERZODESFAJTA");
                    listSzerzFId.add(s);
                    listSzerzF.add(t);
                }
                ObservableList obListSzerzF = FXCollections.observableList(listSzerzF);
                SzerzFajtSzerz.getItems().clear();
                SzerzFajtSzerz.setItems(obListSzerzF);
            } catch (SQLException ex) {
                Logger.getLogger(SzerzrogzitesController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        List<String> listCpv = new ArrayList<>();
        List<String> listCpvId = new ArrayList<>();
        String sql3 = "SELECT CPVKOD, CPVID FROM CPVKODOK WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try {
                ResultSet rs = kapcsolat.adatbazisReport(sql3); 
                while (rs.next()) {
                    String s = rs.getString("CPVID");
                    String t = rs.getString("CPVKOD");
                    listCpvId.add(s);
                    listCpv.add(t);
                }
                ObservableList obListSzerzF = FXCollections.observableList(listCpv);
                CpvSzerz.getItems().clear();
                CpvSzerz.setItems(obListSzerzF);
            } catch (SQLException ex) {
                Logger.getLogger(SzerzrogzitesController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        List<String> listProjekt = new ArrayList<>();
        List<String> listProjektId = new ArrayList<>();
        String sql4 = "SELECT PROJEKT, PROJEKTID FROM PROJEKTEK WHERE LATHATO=TRUE";//meg kell nézni , hogy az oszlopot valóban lathatónak hívják e
            try {
                ResultSet rs = kapcsolat.adatbazisReport(sql4); 
                while (rs.next()) {
                    String s = rs.getString("PROJEKTID");
                    String t = rs.getString("PROJEKT");
                    listProjektId.add(s);
                    listProjekt.add(t);
                }
                ObservableList obListProjekt = FXCollections.observableList(listProjekt);
                ProjektSzerz.getItems().clear();
                ProjektSzerz.setItems(obListProjekt);
            } catch (SQLException ex) {
                Logger.getLogger(SzerzrogzitesController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
        List<String> listSzerzFel = new ArrayList<>();
        List<String> listSzerzFelId = new ArrayList<>();
        String sql5 = "SELECT SZFID, SZERZODOFEL FROM SZERZODO_FEL";
            try {
                ResultSet rs = kapcsolat.adatbazisReport(sql5); 
                while (rs.next()) {
                    String s = rs.getString("SZFID");
                    String t = rs.getString("SZERZODOFEL");
                    listSzerzFelId.add(s);
                    listSzerzFel.add(t);
                }
                ObservableList obListSzerzFel = FXCollections.observableList(listSzerzFel);
                SzerzfelSzerz.getItems().clear();
                SzerzfelSzerz.setItems(obListSzerzFel);
            } catch (SQLException ex) {
                Logger.getLogger(SzerzrogzitesController.class.getName()).log(Level.SEVERE, null, ex);
                uzenet.setText("Hiba az értékkeresés során!");// kell a felületre egy hibaüzenet label
            } finally {
                kapcsolat.closeConnection();
            }
            
}}
