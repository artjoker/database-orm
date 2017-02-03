package com.artjoker.database.orm;


import com.artjoker.orm.DatabaseField;
import com.artjoker.orm.DatabaseTable;

@DatabaseTable(name = "sample_table")
public class DataModel {
    @DatabaseField(name = "id")
    private long id;
    @DatabaseField(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
