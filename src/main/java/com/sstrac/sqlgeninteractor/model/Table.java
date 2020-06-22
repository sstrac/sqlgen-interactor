package com.sstrac.sqlgeninteractor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final String tableName;
    private final List<String> tableFields;

    public Table(@JsonProperty("tableName") String tableName,
                 @JsonProperty("tableFields") String[] tableFields){
        this.tableName = tableName;
        this.tableFields = new ArrayList<String>();
        for(String field: tableFields ){
            this.tableFields.add(field);
        }
    }

    public static Table newTable(String tableName){
        String[] emptyFields = {};
        return new Table(tableName, emptyFields);
    }

    public String getTableName(){
        return this.tableName;
    }

    public List<String> getTableFields(){
        return this.tableFields;
    }

    public void addField(String field){
        this.tableFields.add(field);
    }
}
