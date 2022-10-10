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
public class FXMLinputPesertaController implements Initializable {
    
    boolean editdata = false;
    
    @FXML
    private Button inputPesertaClear;
    @FXML
    private Button inputPesertaSave;
    @FXML
    private TextField inputKodePeserta;
    @FXML
    private TextField inputNamaPeserta;
    @FXML
    private TextField inputAlamatPeserta;
    @FXML
    private TextField inputTeleponPeserta;
    @FXML
    private ComboBox<String> inputJkPeserta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputJkPeserta.setItems(FXCollections.observableArrayList(
        "Laki-Laki","Perempuan"));
    }

    public void execute(pesertaModel d){
        if(!d.getKodePeserta().isEmpty()){
          editdata=true;
          inputKodePeserta.setText(d.getKodePeserta());
          inputNamaPeserta.setText(d.getNamaPeserta());           
          inputJkPeserta.setValue(d.getJkPeserta());
          inputAlamatPeserta.setText(d.getAlamatPeserta());
          inputTeleponPeserta.setText(d.getNamaPeserta());     
        }
    }

    @FXML
    private void inputJkPesertaClick(ActionEvent event) {
    }

    @FXML
    private void inputPesertaSaveClick(ActionEvent event) {
        pesertaModel n = new pesertaModel();
        
        n.setKodePeserta(inputKodePeserta.getText());
        n.setNamaPeserta(inputNamaPeserta.getText());     
        n.setJkPeserta(inputJkPeserta.getValue());
        n.setAlamatPeserta(inputAlamatPeserta.getText());  
        n.setTeleponPeserta(inputTeleponPeserta.getText());

        FXMLDocumentController.dtPeserta.setPesertaModel(n);
        
        if(editdata){
            if(FXMLDocumentController.dtPeserta.update()){
               Alert a = new Alert(Alert.AlertType.INFORMATION,"S U C C E S S",ButtonType.OK);
               a.showAndWait();   
               inputKodePeserta.setEditable(true);        
               inputPesertaClearClick(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"F A I L E D",ButtonType.OK);
                a.showAndWait(); 
            }
        }else if(FXMLDocumentController.dtPeserta.validasi(n.getKodePeserta())<=0){
            if(FXMLDocumentController.dtPeserta.insert()){
               Alert a = new Alert(Alert.AlertType.INFORMATION,"S A V E D",ButtonType.OK);
               a.showAndWait();            
               inputPesertaClearClick(event);
            } else {
               Alert a = new Alert(Alert.AlertType.ERROR,"F A I L E D",ButtonType.OK);
               a.showAndWait();            
            }
        }else{Alert a=new Alert(Alert.AlertType.ERROR,"E X I S T E D",ButtonType.OK);
            a.showAndWait();
            inputKodePeserta.requestFocus();
        }
        
    }

    @FXML
    private void inputPesertaClearClick(ActionEvent event) {
        inputKodePeserta.setText("");        
        inputNamaPeserta.setText("");
        inputJkPeserta.setValue("");       
        inputAlamatPeserta.setText("");
        inputTeleponPeserta.setText("");
    }

}
