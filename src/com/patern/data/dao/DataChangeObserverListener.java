/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.dao;

/**
 *
 * @author Ivan
 */
    public interface DataChangeObserverListener<T> {

        void onItemItsert(T item, boolean result);

        void onItemDelete(T item, boolean result);

        void onItemUpdate(T item, boolean result);

    }