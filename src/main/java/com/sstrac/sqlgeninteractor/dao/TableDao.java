package com.sstrac.sqlgeninteractor.dao;

import com.sstrac.sqlgeninteractor.model.Table;
import com.sstrac.sqlgeninteractor.model.TableRow;

import java.util.List;

public interface TableDao {
    int insertTable(Table table);

    List<TableRow> selectAllTableRows();
}
