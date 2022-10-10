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
public class FXMLinputKelasController implements Initializable {
    
    boolean editdata = false;

    @FXML
    private Button inputKelasSave;
    @FXML
    private Button inputKelasClear;
    @FXML
    private ComboBox<String> inputKategoriKelas;
    @FXML
    private TextField inputNamaKelas;
    @FXML
    private TextField inputKodeKelas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputKategoriKelas.setItems(FXCollections.observableArrayList(
        "Perpajakan","Akuntansi","Informatika","Pariwisata","Matematika","Fisika"));
    }

    public void execute(kelasModel d){
        if(!d.getKodeKelas().isEmpty()){
          editdata=true;
          inputKodeKelas.setText(d.getKodeKelas());
          inputNamaKelas.setText(d.getNamaKelas());           
          inputKategoriKelas.setValue(d.getKategoriKelas());
        }
    }

    @FXML
    private void inputKelasSaveClick(ActionEvent event) {
        kelasModel n = new kelasModel();
        
        n.setKodeKelas(inputKodeKelas.getText());
        n.setNamaKelas(inputNamaKelas.getText());     
        n.setKategoriKelas(inputKategoriKelas.getValue());

        FXMLDocumentController.dtKelas.setKelasModel(n);
        
        if(editdata){
            if(FXMLDocumentController.dtKelas.update()){
               Alert a = new Alert(Alert.AlertType.INFORMATION,"S U C C E S S",ButtonType.OK);
               a.showAndWait();   
               inputKodeKelas.setEditable(true);        
               inputKelasClearClick(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"F A I L E D",ButtonType.OK);
                a.showAndWait(); 
            }
        }else if(FXMLDocumentController.dtKelas.validasi(n.getKodeKelas())<=0){
            if(FXMLDocumentController.dtKelas.insert()){
               Alert a = new Alert(Alert.AlertType.INFORMATION,"S A V E D",ButtonType.OK);
               a.showAndWait();            
               inputKelasClearClick(event);
            } else {
               Alert a = new Alert(Alert.AlertType.ERROR,"F A I L E D",ButtonType.OK);
               a.showAndWait();            
            }
        }else{Alert a=new Alert(Alert.AlertType.ERROR,"E X I S T E D",ButtonType.OK);
            a.showAndWait();
            inputKodeKelas.requestFocus();
        }
    }

    @FXML
    private void inputKelasClearClick(ActionEvent event) {
        inputKodeKelas.setText("");        
        inputNamaKelas.setText("");
        inputKategoriKelas.setValue("");       
    }


    @FXML
    private void inputKategoriKelasClick(ActionEvent event) {
    }
    
}
