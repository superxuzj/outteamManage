package com.boliangshenghe.outteam.controller.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("maven  ---TopicReceiver1接收到消息:"
					+ ((TextMessage) message).getText());
			
			//Result result = JsonUtils.toBean(output, Result.class);//result对象
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}