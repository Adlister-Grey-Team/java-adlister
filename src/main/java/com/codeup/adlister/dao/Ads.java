package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;


import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    //    return list of ads for individual user
    List<Ad> displayAdsFromUserId(Long userId);

    //  return list of ads based on a user search
    List<Ad> searchForAds(String searchForAd);

    List<Ad> listAdsByCatId(long catId);

    void deleteAdByAdId(long id);

    Ad findAdByAdId(long id);

    void updateAd(Ad ad);
}
