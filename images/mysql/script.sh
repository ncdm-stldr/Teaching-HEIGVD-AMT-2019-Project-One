docker build -t mysql .
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=adminpw mysql
