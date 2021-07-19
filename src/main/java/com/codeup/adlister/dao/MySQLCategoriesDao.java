package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class MySQLCategoriesDao implements Categories {


    private Connection conn = null;

    // test code
//    public static void main(String[] args) {
////        DaoFactory.getCatDao().insert(1, 3);
////        System.out.println(DaoFactory.getCatDao().adCategoriesPerAd(1));
//        List<Category> cats = DaoFactory.getCatDao().all();
//        for (Category cat : cats) {
//            System.out.println(cat.getCategory() +" "+ cat.getAd_id());
//        }
//    }

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    // returns all ads categories via category objects that hold the ad_id and category for each.
    public List<Category> all() {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT ad_id, category FROM ad_cat, categories WHERE id = ad_cat.cat_id;");
            ResultSet rs = stmt.executeQuery();
            return createCatsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ad categories.", e);
        }
    }

    @Override
    public Long insert(long adId, long cat) {
//        Category cate = new Category(Long adId, Long cat);
        try {
            String insertQuery = "INSERT INTO ad_cat (ad_id, cat_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setLong(1, adId);
            stmt.setLong(2, cat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding a ad category.", e);
        }
        return 0L;
    }

    private Category extractCat(ResultSet rs) throws SQLException {
        return new Category (
                rs.getLong("ad_id"),
                rs.getString("category")
        );
    }

    private List<Category> createCatsFromResults(ResultSet rs) throws SQLException {
        List<Category> cats = new ArrayList<>();
        while (rs.next()) {
            cats.add(extractCat(rs));
        }
        return cats;
    }

// not working: objects returned do not have correct data types
//    public List<Category> adCategoriesPerAd(long ad_id) {
//        List<Category> cats = new ArrayList<>();
//        String query = "SELECT id FROM categories WHERE id IN (SELECT cat_id FROM ad_cat WHERE ad_id = ?)";
//        try {
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setLong(1, ad_id);
//            ResultSet rs = stmt.executeQuery();
//            return createCatsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error finding categories for a single ad", e);
//        }
//    }


}






