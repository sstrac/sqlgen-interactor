package com.sstrac.sqlgeninteractor.dao;

import com.sstrac.sqlgeninteractor.model.Table;
import com.sstrac.sqlgeninteractor.model.TableRow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("tableDataAccessor")
public class LocalTableDataAccessor implements TableDao {
    private static List<Table> DB = new ArrayList<>();

    @Override
    public int insertTable(Table table){
        DB.add(table);
        return 1;
    }

    @Override
    public List<TableRow> selectAllTableRows(){
        return null;
    }
}
