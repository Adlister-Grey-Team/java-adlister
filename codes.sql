SELECT category
FROM categories
WHERE id IN (
    SELECT cat_id
    FROM ad_cat
    WHERE ad_id = ?
);

Select *
FROM ads
WHERE id IN (
    SELECT ad_id
    FROM ad_cat
    WHERE cat_id = 1
);