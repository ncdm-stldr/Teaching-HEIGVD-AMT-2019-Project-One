cd AffinitiesNetwork
mvn install
docker build -t affinities_network_payara -f images/payara/Dockerfile .
docker start -p 8080:8080 -p 4848:4848 affinities_network_payara
