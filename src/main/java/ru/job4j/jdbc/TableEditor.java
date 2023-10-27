package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            Class.forName(properties.getProperty("driver_class"));
            String url = properties.getProperty("url");
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
        }
    }

    private boolean initStatement(String sql) throws Exception {
        return connection.createStatement().execute(sql);
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s(%s, %s);",
                tableName,
                "id SERIAL PRIMARY KEY",
                 "name Text"
        );
        initStatement(sql);
    }

    public void dropTable(String tableName) throws Exception {
        String sql = String.format("Drop Table %s", tableName);
        initStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format("ALTER TABLE %s Add %s %s", tableName, columnName, type);
        initStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
        initStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s", tableName, columnName, newColumnName);
        initStatement(sql);
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) throws Exception {
        try (TableEditor tableEditor = new TableEditor(new Properties())) {
            tableEditor.initConnection();
            tableEditor.createTable("bookshop");
            System.out.println(tableEditor.getTableScheme("bookshop"));
            tableEditor.addColumn("bookshop", "name_book", "text");
            System.out.println(tableEditor.getTableScheme("bookshop"));
            tableEditor.renameColumn("bookshop", "name_book", "book_name");
            System.out.println(tableEditor.getTableScheme("bookshop"));
            tableEditor.dropColumn("bookshop", "book_name");
            System.out.println(tableEditor.getTableScheme("bookshop"));
            tableEditor.dropTable("bookshop");
        }
    }
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}