package com.jmeter.discovery;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TestJms {
	public static void main(String[] args) {
		
		TestJms jms = new TestJms();
		jms.test();
	}
	public void test(){
		 Session session = null;
		 javax.naming.Context ctx = null;
		 Destination destination = null;
		 MessageProducer producer = null;
		 Connection connection = null;
		 TextMessage textMessage = null;

		String queueName = "sample";
		String destinationUrl = "failover:(tcp:\\localhost:9001)";
		String zooKeeperUrl = "smunirAT-OSX:2181";
		String zooKeeperUser = "admin";
		String zooKeeperPassword = "admin";

		Properties zooKeeperProps = System.getProperties();
		zooKeeperProps.setProperty("zookeeper.url", zooKeeperUrl);
		zooKeeperProps.setProperty("zookeeper.password", zooKeeperPassword);

		Properties contextProps = new Properties();

		contextProps.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		contextProps.setProperty(Context.PROVIDER_URL, destinationUrl);

		// specify queue propertyname as queue.jndiname
		contextProps.setProperty("queue.slQueue", queueName);

		try {
			ctx = new InitialContext(contextProps);
			ConnectionFactory connectionFactory = (ConnectionFactory) ctx
					.lookup("ConnectionFactory");
			connection = connectionFactory.createConnection("admin", "admin");
			connection.start();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = (Destination) ctx.lookup("slQueue");
			producer = session.createProducer(destination);
			textMessage = session.createTextMessage();
			// Using Message selector ObjectClass = ‘AlarmImpl’

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

}
