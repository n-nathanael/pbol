/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.kursus;

/**
 *
 * @author LENOVO
 */
public class kelasModel {
    
    private String kodeKelas;
    private String namaKelas;
    private String kategoriKelas;
    
    public String getKodeKelas(){
        return this.kodeKelas;
    }
    public void setKodeKelas(String kodeKelas){
        this.kodeKelas = kodeKelas;
    }
    
    public String getNamaKelas(){
        return this.namaKelas;
    }
    public void setNamaKelas(String namaKelas){
        this.namaKelas = namaKelas;
    }
    
    public String getKategoriKelas(){
        return this.kategoriKelas;
    }
    public void setKategoriKelas(String kategoriKelas){
        this.kategoriKelas = kategoriKelas;
    }

}
