Fabric8 Deployment with Spring OSGI and profile pids
==============================================================
1. unzip the jboss fuse on to your laptop / server ( i used 6.2.1 jboss fuse)
2. change to etc directory and edit the user.properties
3. uncomment the last line to enable the admin user <this is not advised for production>
4. start the fuse server 
	./start
5. connect to the console by
	./client -u admin -p admin
6. run the command
	fabric:create --wait-for-provisioning --profile fabric
7. create profile exampleprofile
	fabric:profile-create exampleprofile
8. create a container examplecontainer and associate the profile exampleprofile to the container
	fabric:container-create-child --profile exampleprofile root examplecontainer
9. run the commnad
	mvn:install 
9. run the below command to deploy the bundle to the profile
	for dev environment
	-Denvironment=dev fabric8:deploy
	for test environment
	-Denvironment=test fabric8:deploy
	
This is just a way to associate different environments with different set of property files may be not
elegant but works just as good.
