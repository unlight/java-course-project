package com.github.sqlbuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import utils.StringUtils;

public class UpdateQuery {

	private String table;
	private Map<String, String> sets;
	private Collection<String> wheres;

	public UpdateQuery(String table) {
		this.table = table;

		this.sets = new LinkedHashMap<String, String>();
		this.wheres = new LinkedList<String>();
	}

	public UpdateQuery set(String column, Object value) {
		String s;
		if (value == null) {
			s = "";
		} else {
			s = value.toString();
		}
		sets.put(column, s);
		return this;
	}

	public UpdateQuery set(String column, String value) {
		sets.put(column, value);
		return this;
	}

	public UpdateQuery addWhere(String where) {
		wheres.add(where);
		return this;
	}

	@Override
	public String toString() {
		if (sets.isEmpty()) {
			throw new IllegalQueryException("Not contains SET statements!");
		}

		StringBuilder result = new StringBuilder();

		result.append("UPDATE ")
				.append(table)
				.append(" SET ");

		ArrayList strings = new ArrayList();
		for (Entry<String, String> entry : sets.entrySet()) {
			String string = entry.getValue();

			if (string.equals("")) {
				string = "null";
			} else if (string.startsWith("@")) {
				string = string.substring(1);
			} else {
				string = "'" + string + "'";
			}
			strings.add(entry.getKey() + " = " + string);
		}

		result.append(StringUtils.join(strings, ", "));

		if (!wheres.isEmpty()) {
			result.append(" WHERE ");
			result.append(StringUtils.join(wheres, " AND "));
		}

		return result.toString();
	}
}
