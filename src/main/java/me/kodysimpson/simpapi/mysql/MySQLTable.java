package me.kodysimpson.simpapi.mysql;

/**
 * MySQL Table Interface
 * This interface grants you a simple
 * template for allowing you to create a MySQL Database table
 *
 * @author Negative
 */
public interface MySQLTable {

    String getTable();

    void createTable();

}
