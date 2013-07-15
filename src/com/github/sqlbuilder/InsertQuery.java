package com.github.sqlbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import utils.StringUtils;

public class InsertQuery {

    private final String table;
    private Collection<String> columns;
    private List<List<Object>> values;

    public InsertQuery(String table) {
	  this.table = table;
	  this.columns = new LinkedList<String>();
	  this.values = new LinkedList<List<Object>>();
    }

    public InsertQuery columns(String... columns) {
	  Collections.addAll(this.columns, columns);
	  return this;
    }

    public InsertQuery value(Object v) {
	  LinkedList<List<Object>> linkedList = (LinkedList<List<Object>>) this.values;
	  int size = linkedList.size();
	  if (size == 0) {
		List<Object> newValue = new ArrayList<Object>();
		newValue.add(v);
		linkedList.add(newValue);
	  } else {
		linkedList.getFirst().add(v);
	  }
	  return this;
    }

    public InsertQuery values(Object... values) {
	  List<Object> objectList = new ArrayList<>(Arrays.asList(values));
	  this.values.add(objectList);
	  return this;
    }

    @Override
    public String toString() {
	  if (columns.isEmpty()) {
		throw new IllegalQueryException("No columns informed!");
	  }
	  if (values.isEmpty()) {
		throw new IllegalQueryException("No values informed!");
	  }

	  for (List<Object> values : this.values) {
		if (values.size() != columns.size()) {
		    throw new IllegalQueryException("Values size different of columns size");
		}
	  }

	  StringBuilder result = new StringBuilder();

	  result.append("INSERT INTO ")
		    .append(table)
		    .append(" (")
		    .append(StringUtils.join(columns, ", "))
		    .append(")")
		    .append(" VALUES ")
		    .append(StringUtils.join(toValue(), ", "));

	  return result.toString();
    }

    private String[] toValue() {
	  String[] result = new String[values.size()];

	  for (int i = 0; i < result.length; i++) {
		List<Object> objs = values.get(i);
		result[i] = toValue(objs);
	  }

	  return result;
    }

    private String toValue(List<Object> objs) {
	  String[] result = new String[objs.size()];

	  for (int i = 0; i < result.length; i++) {
		if (objs.get(i) instanceof String) {
		    result[i] = "'" + objs.get(i).toString() + "'";
		} else {
		    result[i] = objs.get(i).toString();
		}
	  }

	  return "(" + StringUtils.join(result, ", ") + ")";
    }
}
