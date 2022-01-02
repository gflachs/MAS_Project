package mas.mockup.masMockup.web.api.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mas.mockup.masMockup.web.database.order.Order;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItem;

@Service
public class EmailService {

    public static SimpleMailMessage orderConfirmationTemplate(String items, double totalPrice, double rabatt,
            double versandkosten) {
        SimpleMailMessage message = new SimpleMailMessage();
        String text = "Sehr geehrte Damen und Herren,\nhiermit bestätigten wir Ihnen den Erhalt der folgenden Bestellung:\n"
                + items;

        if (rabatt != 0) {
            text += "Abzüglich einem Rabatt i.H.v" + rabatt + "% \n";
        }
        if (versandkosten != 0) {
            text += "Zuzüglich Versandkosten i.H.v.: " + versandkosten + " €\n";
        }
        text += "Gesamtsumme= " + totalPrice * (100 - rabatt) / 100 + versandkosten + " €\n";
        text += "Wir buchen den Betrag innerhalb der nächsten Tage von Ihrem Konto ab";
        message.setText(text);
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
