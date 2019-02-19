Simple Springboot, mysql, react powered blog

To get this project running locally, you will have to adjust application.properties in Springboot project (database url, user, password)

Create a db and run SQL script in it:

CREATE TABLE blog (
id INT NOT NULL,
title varchar(255),
content varchar(255),
PRIMARY KEY (id)
);

INSERT INTO blog VALUES (1, 'Great blog title', 'Great blog content');
