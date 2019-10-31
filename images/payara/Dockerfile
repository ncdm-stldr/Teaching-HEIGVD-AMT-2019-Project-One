FROM payara/server-full:5.183

ADD AffinitiesNetwork/target/AffinitiesNetwork-1.0-SNAPSHOT.war /opt/payara5/glassfish/domains/domain1/autodeploy/

ADD images/payara/drivers/mysql-connector-java-8.0.11.jar /opt/payara5/glassfish/lib/

RUN echo "AS_ADMIN_PASSWORD=admin" > /tmp/gfpw.txt && \
	# start domain1 and gives all parameters needed to set up jdbc drivers
	# and create connection pool to our affinities network database
	./glassfish/bin/asadmin start-domain domain1 && \
	./glassfish/bin/asadmin --interactive=false --user=admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.cj.jdbc.MysqlDataSource --property user=root:password=adminpw:DatabaseName=affinitiesNetwork:ServerName=db:port=3306:useSSL=false pool_affinitiesNetwork && \
	./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_affinitiesNetwork jdbc/affinitiesNetwork

# optional
# RUN ./glassfish/bin/asadmin stop-domain domain1