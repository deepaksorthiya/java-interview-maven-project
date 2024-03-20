package com.example.corejava;

import java.sql.Connection;

public class EnumSingletonDatabase {

    public static void main(String[] args) {
        SingletonDbConn singleton = SingletonDbConn.getInstance();
        singleton.getConnection();
    }

    private enum SingletonDbConn {
        INSTANCE;

        // instance vars, constructor
        private final Connection connection;

        SingletonDbConn() {
            // Initialize the connection
            System.out.println("Constructor called SingletonDbConn()");
            connection = null;
        }

        // Static getter
        public static SingletonDbConn getInstance() {
            return INSTANCE;
        }

        public Connection getConnection() {
            return connection;
        }
    }
}
