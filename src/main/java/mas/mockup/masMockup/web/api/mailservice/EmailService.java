package mas.mockup.masMockup.web.api.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mas.mockup.masMockup.web.database.order.Order;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItem;

@Service
public class EmailService {

    public static SimpleMailMessage orderConfirmationTemplate(String items, double totalPrice) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setText(
                "Sehr geehrte Damen und Herren,\nhiermit bestätigten wir Ihnen den Erhalt der folgenden Bestellung:\n"
                        + items + "Zu einem Gesamtpreis von: " + totalPrice + " €");
        return message;
    }

    @Autowired
    private JavaMailSender eMailSender;

    public void sendSimpleMessage(MailBody mailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailBody.getFrom());
        message.setTo(mailBody.getTo());
        message.setSubject(mailBody.getSubject());
        message.setText(mailBody.getText());
        eMailSender.send(message);
    }
}
