/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.dao;

import java.util.ArrayList;
import java.util.List;

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