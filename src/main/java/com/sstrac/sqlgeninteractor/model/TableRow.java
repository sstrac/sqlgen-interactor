package com.sstrac.sqlgeninteractor.model;

public class TableRow {
    private String tableName;
    private String tableField;

    private TableRow(String tableName, String tableField){
        this.tableField = tableField;
        this.tableName = tableName;
    }

    public static TableRow createTableRow(String tableName, String tableField){
        return new TableRow(tableName, tableField);
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableField() {
        return tableField;
    }
}
