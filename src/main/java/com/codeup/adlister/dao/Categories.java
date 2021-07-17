package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Categories {
    Long insert(Long ad_id, Long cat);

    List<String> printCategories (Long ad_id);
}
