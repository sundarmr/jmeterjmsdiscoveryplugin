package com.jmeter.discovery;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;

public class DiscoveryFabricProducer implements JavaSamplerClient {
	Logger LOG = org.slf4j.LoggerFactory
			.getLogger(DiscoveryFabricProducer.class);
	private Session session = null;
	private javax.naming.Context ctx = null;
	private Destination destination = null;
	private MessageProducer producer = null;
	private Connection connection = null;
	private TextMessage textMessage = null;
	private final String QUEUE_NAME = "QueueName";
	private final String DESTINATION_URL = "Destination Url";
	private final String ZOOKEEPER_URL = "Zookeeper Url";
	private final String ZOOKEEPER_PASSWORD = "Zookeeper Password";
	private final String ZOOKEEPER_USER = "Zookeeper User";
	private final String MESSAGE = "message";
	private final String SYS_ZOOKEEPER_URL = "zookeeper.url";
	private final String SYS_ZOOKEEPER_PASS = "zookeeper.password";
	private final String SYS_ZOOKEEPER_USR = "zookeeper.userName";

	public Arguments getDefaultParameters() {
		Arguments args = new Arguments();
		args.addArgument(QUEUE_NAME, "");
		args.addArgument(DESTINATION_URL, "");
		args.addArgument(ZOOKEEPER_URL, "");
		args.addArgument(ZOOKEEPER_PASSWORD, "");
		args.addArgument(ZOOKEEPER_USER, "");
		args.addArgument(MESSAGE,"");
		return args;
	}

	public SampleResult runTest(JavaSamplerContext arg0) {
		SampleResult result = new SampleResult();
		try {

			result.setDataType(SampleResult.TEXT);
			result.setSampleLabel("External Discovery Url Test");

			textMessage.setText(arg0.getParameter(MESSAGE));
			result.sampleStart();
			producer.send(textMessage);
			result.setSuccessful(true);
			result.sampleEnd();
			result.setResponseMessage("Delivered");
		} catch (JMSException e) {
			LOG.error(e.getMessage(), e);
			result.setSuccessful(false);
			result.setResponseMessage(e.getMessage());
		}
		return result;
	}

	public void setupTest(JavaSamplerContext testContext) {
		LOG.info("Setting up thread for Thread : " + this.hashCode());
		
		
		String queueName = testContext.getParameter(QUEUE_NAME);
		String destinationUrl = testContext.getParameter(DESTINATION_URL);
		String zooKeeperUrl = testContext.getParameter(ZOOKEEPER_URL);
		String zooKeeperUser = testContext.getParameter(ZOOKEEPER_PASSWORD);
		String zooKeeperPassword = testContext.getParameter(ZOOKEEPER_PASSWORD);

		Properties zooKeeperProps = System.getProperties();
		zooKeeperProps.setProperty(SYS_ZOOKEEPER_URL, zooKeeperUrl);
		zooKeeperProps.setProperty(SYS_ZOOKEEPER_PASS, zooKeeperPassword);
		zooKeeperProps.setProperty(SYS_ZOOKEEPER_USR, zooKeeperUser);

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
			LOG.error(e.getMessage(), e);

		}
		LOG.info("Setting up thread for Thread : " + this.hashCode());
	}

	public void teardownTest(JavaSamplerContext arg0) {
		try {
			if (producer != null) {
				producer.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (JMSException je) {
			LOG.error(je.getMessage(), je);
		}

	}

}
