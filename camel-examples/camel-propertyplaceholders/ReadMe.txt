Camel Properties Samples

Camel Bridge Properties
=======================
Code example of how to use org.apache.camel.spring.spi.BridgePropertyPlaceholderConfigurer for resolving
property files and use the same in both came and spring contexts.
mvn -DcontextFile=camelBridgeProps.xml camel:run

Camel PropertyPlaceHolder
=========================
Code example of how to use the property placeholder within camel context


mvn -DcontextFile=camelProperties.xml -DpropFileLocation=/Users/smunirat/apps/mycode/camel-properties/src/main/resources/camelProperties.properties camel:run
Camel Property With Spring Bean
================================
How to resolve the same property file from Spring and Camel Context using org.apache.camel.component.properties.PropertiesComponent
class and Camel Property Place Holder

mvn -DcontextFile=camelPropsWithSpringBean.xml camel:run

Camel Spring Props
==================
How to use the PropertyPlaceHolderResolver to resolve properties #Least Preferred Way
mvn -DcontextFile=camelSpringProps.xml camel:run


