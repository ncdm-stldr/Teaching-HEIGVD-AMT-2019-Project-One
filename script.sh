cd AffinitiesNetwork
mvn clean install
cd ..
docker-compose down
docker-compose --build
