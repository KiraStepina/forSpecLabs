package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Server implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(Server.class);

	/**
	 * Implementation of <code>MessageListener</code>.
	 */
	public void onMessage(Message message) {
		try {
			int messageCount = message.getIntProperty("messageCount");
			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = tm.getText();
				logger.info("Processed message '{}'.  value={}", msg, messageCount);
			}
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
