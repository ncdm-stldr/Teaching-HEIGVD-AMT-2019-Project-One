# Instructions
## How to run project with docker-compose
From the root folder run the script.sh script.
## How to run locally
1. From folder AffinitiesNetwork, run ``` mvn clean install```. This will create a war file in the target subfolder.
2. Start a jave ee application server. We used payara during developpement. Include a mysql connector into the server.
3. From the admin console (or using tool asadmin) deploy the war file created by maven (during one of previous steps).
4. Start a mysql database. Use the scripts found in subfolder (from root folder) image images\mysql\data to create the database.
5. Create a connection pool in java ee application server to connect to the database.
6. Now it should be possible to perform http queries on the server at <base_url>/affinitiesNetwork/index
