/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.math.BigDecimal;

/**
 *
 * @author damirl
 */
public class Tipster {

    Integer id;
    String naziv;
    String napomena;
    Integer grupaId;
    String igram;
    BigDecimal mt;

    public Tipster() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Integer getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(Integer grupaId) {
        this.grupaId = grupaId;
    }

    public String getIgram() {
        return igram;
    }

    public void setIgram(String igram) {
        this.igram = igram;
    }

    public BigDecimal getMt() {
        return mt;
    }

    public void setMt(BigDecimal mt) {
        this.mt = mt;
    }
}
