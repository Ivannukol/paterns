package com.patern.data.dao;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author abrel
 * @param <T>
 */
public class Request<T> {

    private Class item;

    public Request() {

    }

    public Map<String, String> fieldsWhere = new HashMap<>();

    private void add(String field, String value) {
        fieldsWhere.put(field, value);
    }

    public String getSQL() {
        StringBuilder query = new StringBuilder("SELECT * FROM " + item.getSimpleName().toUpperCase() + "S WHERE ");
        fieldsWhere.entrySet().stream().forEach((Map.Entry<String, String> i) -> {
            query.append(String.format("%s='%s' AND ", i.getKey(), i.getValue()));
        });
       query.delete(query.length()-"AND ".length(), query.length());
        return query.toString();
    }

    public static class Builder<T> {

        private final Request<T> request;

        public Builder(Class clazz) {
            this.request = new Request<>();
            request.item = clazz;
        }

        public Builder<T> where(String field, String value) {
            request.add(field, value);
            return this;
        }

        public Request<T> build() {
            return request;
        }

    }
}
