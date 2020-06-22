package com.sstrac.sqlgeninteractor.service;

import com.sstrac.sqlgeninteractor.dao.TableDao;
import com.sstrac.sqlgeninteractor.model.Table;
import com.sstrac.sqlgeninteractor.model.TableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableDao tableDao;

    @Autowired
    public TableService(@Qualifier("postgres") TableDao tableDao){
        this.tableDao = tableDao;
    }

    public int addTable(Table table){
        this.tableDao.insertTable(table);
        return 1;
    }

    public List<Table> getAllTables(){
        List<Table> tables = new ArrayList<>();
        List<TableRow> rows = this.tableDao.selectAllTableRows();
        for(TableRow row: rows){
            Table table = getTableByName(row.getTableName(), tables);
            if(table != null){
                table.addField(row.getTableField());
            } else {
                Table newTable = Table.newTable(row.getTableName());
                newTable.addField(row.getTableField());
                tables.add(newTable);
            }
        }
        return tables;
    }

    public static Table getTableByName(String tableName, List<Table> tables){
        for(Table table: tables) {
            if (table.getTableName().equals(tableName)) {
                return table;
            }
        }
        return null;
    }

    public static List<String> getTablesNames(List<Table> tables){
        List tableNames = new ArrayList<String>();
        for(Table table: tables){
            tableNames.add(table.getTableName());
        }

        return tableNames;
    }
}
