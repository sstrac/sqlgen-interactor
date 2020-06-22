package com.sstrac.sqlgeninteractor.api;

import com.sstrac.sqlgeninteractor.model.Table;
import com.sstrac.sqlgeninteractor.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RequestMapping("api/table")
@RestController
public class TableController {
    private final TableService tableService;

    @Autowired
    TableController(TableService tableService){
        this.tableService = tableService;
    }

    @PostMapping
    public void addTable(@RequestBody Table table){
        tableService.addTable(table);
    }

    @GetMapping
    public List<Table> getAllTables(){ return tableService.getAllTables(); }
}
