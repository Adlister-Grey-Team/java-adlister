package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Categories {
    Long insert(long ad_id, long cat);

//    List<Category> adCategoriesPerAd(long ad_id);

    List<Category> all();
}
