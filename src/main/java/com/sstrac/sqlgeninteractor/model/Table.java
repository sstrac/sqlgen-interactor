package com.sstrac.sqlgeninteractor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final String tableName;
    private final List<String> tableFields;

    public Table(@JsonProperty("tableName") String tableName,
                 @JsonProperty("tableFields") List<String> tableFields){
        this.tableName = tableName;
        this.tableFields = tableFields;
    }

    public static Table newTable(String tableName){
        return new Table(tableName, new ArrayList<>());
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
