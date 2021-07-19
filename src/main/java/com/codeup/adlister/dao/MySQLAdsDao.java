package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        PreparedStatement statement = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public List<Ad> displayAdsFromUserId(Long userId) {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by user id", e);
        }
    }

    public List<Ad> searchForAds(String searchForAd) {
        String sql = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?;";
        String searchUsingUserInput = "%" + searchForAd + "%";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchUsingUserInput);
            stmt.setString(2, searchUsingUserInput);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    public List<Ad> listAdsByCatId(long catId) {
        String query = "SELECT * FROM ads WHERE id IN (SELECT ad_id FROM ad_cat WHERE cat_id = ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, catId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error listing ads by category.", e);
        }
    }

    public void deleteAdByAdId(long id) {
        try {
            String query = "DELETE FROM ads WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad", e);
        }
    }

    @Override
    public Ad findAdByAdId(long id) {
        System.out.println(id);
        String query = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by id", e);
        }
    }

    public void updateAd(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by user email", e);
        }
    }

//    public static void main(String[] args) {
//        Ad ad1 = new Ad( 16,1, "does it work tho","asdfsdffjdsfa");
//        System.out.println(ad1.getTitle());
//        System.out.println(ad1.getDescription());
//        System.out.println(ad1.getId());
//        DaoFactory.getAdsDao().updateAd(ad1);
//    }

}
