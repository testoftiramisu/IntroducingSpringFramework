package io.testoftiramisu.spring.jms;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.utils.XmlUtils;
import io.testoftiramisu.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class JMSConsumer implements MessageListener {

    @Autowired
    DocumentDAO documentDAO;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            Document document = XmlUtils.fromXML(textMessage.getText(), Document.class);
            documentDAO.save(document);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
