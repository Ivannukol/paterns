/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abrel
 */
public interface RepositoryInterface<T> {

    boolean insert(T item) throws SQLException;

    boolean update(T item) throws SQLException;

    ArrayList<T> getAll() throws SQLException;

    boolean delete(T item) throws SQLException;

    void registerDataChangeObserver(Repository.DataChangeObserverListener<T> listener);

    void unregisterDataChangeObserver(Repository.DataChangeObserverListener<T> listener);

}
