package com.camel.spring.osgiprops;

import org.apache.camel.PropertyInject;

public class SpringOsgiTestBean {
	@PropertyInject("{{injectByAnnotation}}")
	private String injectByAnnotation;

	private String injectedPropertySpring;

	

	public String getInjectByAnnotation() {
		return injectByAnnotation;
	}

	public void setInjectByAnnotation(String injectByAnnotation) {
		this.injectByAnnotation = injectByAnnotation;
	}

	public String getInjectedPropertySpring() {
		return injectedPropertySpring;
	}

	public void setInjectedPropertySpring(String injectedPropertySpring) {
		this.injectedPropertySpring = injectedPropertySpring;
	}

	public String printProperties() {
		return "Injected By Annotation :" + getInjectByAnnotation()
				+ " : " + " Injected by Spring : "
				+ getInjectedPropertySpring();
	}

}
