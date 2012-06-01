package client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class Client {

	private static final Logger logger = LoggerFactory.getLogger(Client.class);

	private JmsTemplate template = null;
	private int messageCount = 10;

	/**
	 * Generates JMS messages
	 */
	public void generateMessages() throws JMSException {
		for (int i = 0; i < messageCount; i++) {
			final int index = i;
			final String text = "Message number is " + i + ".";

			template.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage(text);
					message.setIntProperty("messageCount", index);
					logger.info("Sending message: " + text);
					return message;
				}
			});
		}
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
}