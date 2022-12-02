package com.example.frontend;

import java.sql.*;
import java.util.Scanner;

public class Database {

        static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
        static final String USER_NAME = "COMP214_F22_zo_122";
        static final String PASS = "password";


        public static void main(String[] args) {

        }


        static public String getData() {
            String result="";
            try {
                Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASS);

                Statement st = connection.createStatement();

                String query = "SELECT * FROM ORDER_DETAILS";

                ResultSet resultSet = st.executeQuery(query);



                while (resultSet.next()) {
                    int orderID = resultSet.getInt(1);
                    int cusID = resultSet.getInt(2);
                    int productID = resultSet.getInt(3);
                    double totalCost = resultSet.getInt(6);
                    double comission = resultSet.getInt(7);

                    result+= "Order ID: " + orderID + ", Customer ID: " + cusID + ", Car ID: "+ productID
                            +", Total Cost: $"+totalCost + ", Comission: $"+comission +'\n';
                }
                resultSet.close();
                connection.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        static public void updateData() {
            try {
                Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASS);
                Statement st = connection.createStatement();
                String query = "BEGIN DBMS_OUTPUT.PUT_LINE(PLACE_ORDER("+HelloApplication.idproduct+","+HelloApplication.idcustomer+","
                        +HelloApplication.salesid + ",'"+HelloApplication.shipstatus+"')); END;";
                st.executeUpdate(query);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    static public String getSales() {
        String result="";
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASS);

            Statement st = connection.createStatement();

            String query = "SELECT * FROM SALES";

            ResultSet resultSet = st.executeQuery(query);



            while (resultSet.next()) {
                int salesID = resultSet.getInt(1);
                String fname =  resultSet.getString(2);
                String lname =  resultSet.getString(3);
                String email =  resultSet.getString(4);
                String phone =  resultSet.getString(5);
                int comission = resultSet.getInt(6);

                result+= "Sales ID: " + salesID + ", First Name: " + fname + ", Last Name: "+ lname
                        +", Email: "+email + ", Phone : "+phone+", Comission: $"+comission +'\n';
            }
            resultSet.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    }


