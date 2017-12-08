/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.pojo;

/**
 *
 * @author Ivan
 */
public class Paterns {

    private int id;
    private String paterns;
    private String typeParent;
    private int sortPatern;

    public Paterns(int id, String paterns, String type_parent, int sort_patern) {
        this.id = id;
        this.paterns = paterns;
        this.typeParent = type_parent;
        this.sortPatern = sort_patern;
    }

    public Paterns() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaterns() {
        return paterns;
    }

    public void setPaterns(String paterns) {
        this.paterns = paterns;
    }

    public String getTypeParent() {
        return typeParent;
    }

    public void setTypeParent(String typeParent) {
        this.typeParent = typeParent;
    }

    public int getSortPatern() {
        return sortPatern;
    }

    public void setSortPatern(int sortPatern) {
        this.sortPatern = sortPatern;
    }

}
