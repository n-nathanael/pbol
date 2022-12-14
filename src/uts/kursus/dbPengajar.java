/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.kursus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mypc
 */
public class dbPengajar {
    
    private pengajarModel dt = new pengajarModel();    
    public pengajarModel getPengajarModel(){ 
        return(dt);
    }
    public void setPengajarModel(pengajarModel s){ 
        dt=s;
    }
    
    public ObservableList<pengajarModel>  Load() {
        try {
            ObservableList<pengajarModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodePengajar, namaPengajar, jkPengajar, alamatPengajar, teleponPengajar from pengajar");
            int i = 1;
            while (rs.next()) {
                pengajarModel d=new pengajarModel();
                
                d.setKodePengajar(rs.getString("kodePengajar"));                
                d.setNamaPengajar(rs.getString("namaPengajar"));        
                d.setJkPengajar(rs.getString("jkPengajar"));
                d.setAlamatPengajar(rs.getString("alamatPengajar"));
                d.setTeleponPengajar(rs.getString("teleponPengajar"));
                
                tableData.add(d);                
                i++;            
            }
            con.tutupKoneksi();            
            return tableData;
        } catch (Exception e) {            
            e.printStackTrace();            
            return null;        
        }
    }
    public int validasi(String nomor) {
        int val = 0;
        try {         
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from pengajar where kodePengajar = '" + nomor + "'");
            while (rs.next()) {                
                val = rs.getInt("jml");            
            }            
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }
    
    public boolean insert() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {       
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into pengajar (kodePengajar ,namaPengajar, jkPengajar, alamatPengajar, teleponPengajar) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getPengajarModel().getKodePengajar());           
            con.preparedStatement.setString(2, getPengajarModel().getNamaPengajar());
            con.preparedStatement.setString(3, getPengajarModel().getJkPengajar()); 
            con.preparedStatement.setString(4, getPengajarModel().getAlamatPengajar());   
            con.preparedStatement.setString(5, getPengajarModel().getTeleponPengajar()); 
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }  
    }
    public boolean delete(String nomor) {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from pengajar where kodePengajar  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }
    public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update peserta set namaPengajar = ?, jkPengajar = ?, alamatPengajar = ?, teleponPengajar = ? where  kodePengajar = ? ");
            con.preparedStatement.setString(1, getPengajarModel().getKodePengajar());           
            con.preparedStatement.setString(2, getPengajarModel().getNamaPengajar());
            con.preparedStatement.setString(3, getPengajarModel().getJkPengajar()); 
            con.preparedStatement.setString(4, getPengajarModel().getAlamatPengajar());   
            con.preparedStatement.setString(5, getPengajarModel().getTeleponPengajar()); 
            con.preparedStatement.executeUpdate();          
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }    
    }
    public ObservableList<pengajarModel>  cariPengajar(String namaPengajar) {
        try {    
            ObservableList<pengajarModel> 	tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from pengajar WHERE namaPengajar LIKE '" + namaPengajar + "%'");
        int i = 1;
        while(rs.next()){
            pengajarModel d = new pengajarModel();
            d.setKodePengajar(rs.getString("kodePengajar"));
            d.setNamaPengajar(rs.getString("namaPengajar"));
            d.setJkPengajar(rs.getString("jkPengajar"));
            d.setAlamatPengajar(rs.getString("alamatPengajar"));
            d.setTeleponPengajar(rs.getString("teleponPengajar"));
            tableData.add(d);
            i++;
        }
        con.tutupKoneksi();
        return tableData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
