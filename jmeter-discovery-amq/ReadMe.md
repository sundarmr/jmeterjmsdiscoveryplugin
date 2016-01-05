1. Download latest version of jmeter.
2. Copy the below jars to Jmeter lib/ext directory
	fabric-zookeeper-1.2.0.redhat-133.jar,
	fabric-utils-1.2.0.redhat-133.jar,
	fabric-groups-1.2.0.redhat-133.jar,
	fabric-api-1.2.0.redhat-133.jar,
	zookeeper-3.4.6.jar,
	camel-test-spring-2.15.1.jar,
	camel-test-2.15.1.jar,
	camel-spring-2.15.1.jar,
	camel-jms-2.14.1.jar,
	camel-core-2.15.1.jar,
	activemq-spring-5.11.0.jar,
	activemq-protobuf-1.1.jar,
	activemq-pool-5.11.0.jar,
	activemq-openwire-legacy-5.11.0.redhat-620133.jar,
	activemq-jms-pool-5.11.0.jar,
	activemq-core-5.7.0.jar,
	activemq-client-5.11.0.jar,
	activemq-camel-5.11.0.jar,
	activemq-broker-5.11.0.redhat-620133.jar,
	management-api-1.1-rev-1.jar,
	mq-fabric-1.2.0.redhat-133.jar,
	mq-discovery-1.2.0.redhat-133.jar,
	guava-17.0.jar,
	jackson-databind-2.4.3.jar,
	jackson-annotations-2.4.3.jar,
	jackson-core-2.4.3.jar.

3. Run mvn install and create a jar out of the current project.
4. Copy the jar to lib/ext directory of jmeter.
5. Run Jmeter.
6. Test case Discovery.jmx is provided in the data directory ,copy this file to any location on your system accessible to jmeter installation.
8. Click on File and open and navigate to the directory where the test case was copied to and select it.
9. Run the test case.
This test simulates only producer code Reference : https://github.com/FuseByExample/external-mq-fabric-client