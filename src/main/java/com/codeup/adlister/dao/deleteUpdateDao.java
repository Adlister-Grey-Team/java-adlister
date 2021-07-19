//package com.codeup.adlister.dao;
//
//import com.mysql.cj.jdbc.Driver;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class deleteUpdateDao implements updateDelete {
//    private Connection connection = null;
//
//    public static void main(String[] args) {
//        DaoFactory.getUpDelDao().delete(9);
//    }
//    public deleteUpdateDao(Config config){
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUser(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//    }
//
//    @Override
//    public Long delete(long id) {
//        try {
//            String query = "DELETE FROM ad_cat WHERE ad_id = ?";
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setLong(1, id);
//            stmt.executeUpdate();
//            String query2 = "DELETE FROM ads WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query2);
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
