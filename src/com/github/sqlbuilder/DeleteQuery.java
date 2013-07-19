package com.github.sqlbuilder;

import java.util.Collection;
import java.util.LinkedList;

import utils.StringUtils;

public class DeleteQuery {

    private final String table;
    private Collection<String> wheres;

    public DeleteQuery(String table) {
        this.table = table;
        wheres = new LinkedList<String>();
    }

    public DeleteQuery addWhere(String where) {
        wheres.add(where);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("DELETE FROM ")
                .append(table);

        if (!wheres.isEmpty()) {
            result.append(" WHERE ")
                    .append(StringUtils.join(wheres, " AND "));
        }

        return result.toString();
    }
}