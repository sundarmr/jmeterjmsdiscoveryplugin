package com.camel.example.properties;

import org.apache.camel.PropertyInject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class SampleSpringProperties {
	private static final Logger LOG = LoggerFactory.getLogger(SampleSpringProperties.class);
	private String fromCamelProp;
	@PropertyInject("{{test.property}}")
	private String propInjection;
	public String getFromCamelProp() {
		return fromCamelProp;
	}
	public void setFromCamelProp(String fromCamelProp) {
		this.fromCamelProp = fromCamelProp;
	}
	public String getPropInjection() {
		return propInjection;
	}
	public void setPropInjection(String propInjection) {
		this.propInjection = propInjection;
	}
	public String printProperties(){
		
		LOG.info("From Camel Project : "+getFromCamelProp());
		LOG.info("Form Properties Injection : "+getPropInjection());
		return getFromCamelProp()+" : "+getPropInjection();
	}
}
