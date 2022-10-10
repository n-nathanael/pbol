/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.kursus;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mypc
 */
public class FXMLinputPengajarController implements Initializable {
    
    boolean editdata = false;

    @FXML
    private Button inputPengajarClear;
    @FXML
    private Button inputPengajarSave;
    @FXML
    private ComboBox<String> inputJkPengajar;
    @FXML
    private TextField inputTeleponPengajar;
    @FXML
    private TextField inputAlamatPengajar;
    @FXML
    private TextField inputNamaPengajar;
    @FXML
    private TextField inputKodePengajar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputJkPengajar.setItems(FXCollections.observableArrayList(
        "Laki-Laki","Perempuan"));
    }

    public void execute(pengajarModel d){
        if(!d.getKodePengajar().isEmpty()){
          editdata=true;
          inputKodePengajar.setText(d.getKodePengajar());
          inputNamaPengajar.setText(d.getNamaPengajar());           
          inputJkPengajar.setValue(d.getJkPengajar());
          inputAlamatPengajar.setText(d.getAlamatPengajar());
          inputTeleponPengajar.setText(d.getNamaPengajar());     
        }
    }

    @FXML
    private void inputPengajarClearClick(ActionEvent event) {
        inputKodePengajar.setText("");        
        inputNamaPengajar.setText("");
        inputJkPengajar.setValue("");       
        inputAlamatPengajar.setText("");
        inputTeleponPengajar.setText("");
    }

    @FXML
    private void inputPengajarSaveClick(ActionEvent event) {
        pengajarModel n = new pengajarModel();
        
        n.setKodePengajar(inputKodePengajar.getText());
        n.setNamaPengajar(inputNamaPengajar.getText());     
        n.setJkPengajar(inputJkPengajar.getValue());
        n.setAlamatPengajar(inputAlamatPengajar.getText());  
        n.setTeleponPengajar(inputTeleponPengajar.getText());

        FXMLDocumentController.dtPengajar.setPengajarModel(n);
        
        if(editdata){
            if(FXMLDocumentController.dtPengajar.update()){
               Alert a = new Alert(Alert.AlertType.INFORMATION,"S U C C E S S",ButtonType.OK);
               a.showAndWait();   
               inputKodePengajar.setEditable(true);        
               inputPengajarClearClick(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"F A I L E D",ButtonType.OK);
                a.showAndWait(); 
            }
        }else if(FXMLDocumentController.dtPengajar.validasi(n.getKodePengajar())<=0){
            if(FXMLDocumentController.dtPengajar.insert()){
               Alert a = new Alert(Alert.AlertType.INFORMATION,"S A V E D",ButtonType.OK);
               a.showAndWait();            
               inputPengajarClearClick(event);
            } else {
               Alert a = new Alert(Alert.AlertType.ERROR,"F A I L E D",ButtonType.OK);
               a.showAndWait();            
            }
        }else{Alert a=new Alert(Alert.AlertType.ERROR,"E X I S T E D",ButtonType.OK);
            a.showAndWait();
            inputKodePengajar.requestFocus();
        }
    }

    @FXML
    private void inputJkPengajarClick(ActionEvent event) {
    }
}
