package phonebook.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import phonebook.Application;

public class Date extends java.util.Date {
    
    public Date(java.util.Date d) {
        this(d.getTime());
    }

    public Date(long date) {
        super(date);
    }

    public static Date fromString(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        try {
            date = formatter.parse(s);
        } catch (ParseException ex) {
            Application.handleException(ex);
            date = new java.util.Date();
        }
        Date d = new Date(date.getTime());
        return d;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(this);
        return date;
    }
}