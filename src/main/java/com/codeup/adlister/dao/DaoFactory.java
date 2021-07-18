package com.codeup.adlister.dao;

public class DaoFactory {

    private static Ads adsDao;
    private static Users usersDao;
    private static Categories categoryDao;
    private static updateDelete upDelDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
    public static Categories getCatDao(){
        if (categoryDao == null){
            categoryDao = new MySQLCategoriesDao(config);
        }
        return categoryDao;
    }
    public static updateDelete getUpDelDao(){
        if(upDelDao == null){
            upDelDao = new deleteUpdateDao(config);
            }
            return upDelDao;
    }
}
