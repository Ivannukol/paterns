/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abrel
 * @param <T>
 */
public class Repository<T> implements RepositoryInterface<T> {

    public Table<T> table;
    private DataChangeObserver<T> observer;

    public Repository(Table<T> table) {
        this.table = table;
        observer = new DataChangeObserver<>();
    }

    @Override
    public boolean insert(T item) throws SQLException {
        boolean result = table.insert(item);
        observer.onItemItsert(item, result);
        return result;
    }

    @Override
    public boolean update(T item) throws SQLException {
        boolean result = table.insert(item);
        observer.onItemUpdate(item, result);
        return result;
    }

    @Override
    public ArrayList<T> getAll() throws SQLException {
        return table.getAll();
    }

    @Override
    public boolean delete(T item) throws SQLException {
        boolean result = table.insert(item);
        observer.onItemDelete(item, result);
        return result;
    }

    public interface DataChangeObserverListener<T> {

        void onItemItsert(T item, boolean result);

        void onItemDelete(T item, boolean result);

        void onItemUpdate(T item, boolean result);

    }

    public class DataChangeObserver<T> implements DataChangeObserverListener<T> {

        private List<DataChangeObserverListener<T>> list;

        public DataChangeObserver() {
            list = new ArrayList();
        }

        public void add(DataChangeObserverListener<T> listener) {
            list.add(listener);
        }

        public void delete(DataChangeObserverListener<T> listener) {
            list.remove(listener);
        }

        @Override
        public void onItemItsert(T item, boolean result) {
            for (DataChangeObserverListener i : list) {
                i.onItemItsert(item, result);
            }
        }

        @Override
        public void onItemDelete(T item, boolean result) {
            for (DataChangeObserverListener i : list) {
                i.onItemDelete(item, result);
            }
        }

        @Override
        public void onItemUpdate(T item, boolean result) {
            for (DataChangeObserverListener i : list) {
                i.onItemUpdate(item, result);
            }
        }

    }

}
