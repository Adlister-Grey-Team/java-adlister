USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ad_cat;
DROP TABLE IF EXISTS categories;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL UNIQUE,
    email VARCHAR(240) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE categories(
                           id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                           category VARCHAR (40) NOT NULL,
                           PRIMARY KEY (id)
);

CREATE TABLE ad_cat(
                       ad_id INT UNSIGNED NOT NULL,
                       cat_id INT UNSIGNED NOT NULL,
                       FOREIGN KEY (ad_id) REFERENCES ads(id) ON DELETE CASCADE,
                       FOREIGN KEY (cat_id) REFERENCES categories(id)
                           ON DELETE CASCADE
);

INSERT INTO categories (category)
VALUES ("Automotive"),
       ("Beauty and Health"),
       ("Books"),
       ("Clothing"),
       ("Computers"),
       ("Electronics"),
       ("Home and Garden"),
       ("Movies, Music, Games"),
       ("Outdoors"),
       ("Pets"),
       ("Sports");
