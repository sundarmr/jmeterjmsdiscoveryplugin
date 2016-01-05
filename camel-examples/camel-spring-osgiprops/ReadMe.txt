Camel Router Spring Project
=================================================================================
Fabric Deployment on a profile named profilex and container named containerx
=================================================================================
1. Create the properties file osgi.props.properties on the profilex 
2. run the command 
	fabric:profile-edit --bundles mvn:com.camel.examples/camel-spring-osgiprops/<version> profilex
3. run the command
	fabric:container-add-profile containerx profilex
4. The result should be in the logs as below
------------------------------------------------------------------------------------------------------------------
route1 This is resolved from camel : Resolved by Camel1
route1 The Body is Injected By Annotation :Injected via Annotation1 :  Injected by Spring : Injected via Spring1
-------------------------------------------------------------------------------------------------------------------
===========================
Standalone deployment
===========================
1. Copy the osgi.props.properties file to the ${karaf.home}/etc directory
2. Copy the bundle camel-spring-osgiprops.jar to the deploy directory
3. The result should be in the logs as below

------------------------------------------------------------------------------------------------------------------
route1 This is resolved from camel : Resolved by Camel1
route1 The Body is Injected By Annotation :Injected via Annotation1 :  Injected by Spring : Injected via Spring1
-------------------------------------------------------------------------------------------------------------------
===========================
fabric8:maven plugin
===========================