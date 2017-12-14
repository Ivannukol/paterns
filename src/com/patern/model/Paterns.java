/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.model;

/**
 *
 * @author Ivan
 */
public class Paterns {
    private int id;
    private String paterns;
    private String type_parent;
    private int sort_patern;

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

    public String getType_parent() {
        return type_parent;
    }

    public void setType_parent(String type_parent) {
        this.type_parent = type_parent;
    }

    public int getSort_patern() {
        return sort_patern;
    }

    public void setSort_patern(int sort_patern) {
        this.sort_patern = sort_patern;
    }
    
}
