package com.sstrac.sqlgeninteractor.dao;

import com.sstrac.sqlgeninteractor.SqlgenInteractorApplication;
import com.sstrac.sqlgeninteractor.model.Table;
import com.sstrac.sqlgeninteractor.model.TableRow;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository("postgres")
public class TableDataAccessor implements TableDao {
    private final static Logger LOG = Logger.getLogger(SqlgenInteractorApplication.class.getName());
    private JdbcTemplate jdbcTemplate;

    TableDataAccessor(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTable(Table table) {
        String sql = "INSERT INTO SQLGenTables (table_name, table_field) VALUES (?,?);";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String field = table.getTableFields().get(i);
                ps.setString(1, table.getTableName());
                ps.setString(2, field);
            }

            @Override
            public int getBatchSize() {
                return table.getTableFields().size();
            }
        });
        return 0;
    }

    @Override
    public List<TableRow> selectAllTableRows(){
        String sql = "SELECT table_name, table_field FROM SQLGenTables;";
        List<TableRow> tableRows = jdbcTemplate.query(sql, (resultSet, i) ->
            TableRow.createTableRow(
                    resultSet.getString("table_name"),
                    resultSet.getString("table_field")
            )
        );
        return tableRows;
    }

}
