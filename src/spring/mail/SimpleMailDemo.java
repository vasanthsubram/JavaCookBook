package spring.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author vsubramanian
 */
public class SimpleMailDemo {

    private MailSender mailSender;
    private SimpleMailMessage messageTemplate;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setMessageTemplate(SimpleMailMessage messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/mail/mailConfig.xml");
        SimpleMailDemo demo = (SimpleMailDemo) context.getBean("mailDemo");

        SimpleMailMessage message = new SimpleMailMessage(demo.messageTemplate);
        message.setFrom("vsubramanian@abclegal.com");
        message.setTo("vasanth_subramanian@yahoo.com");
        message.setText("Test");

        try {
            demo.mailSender.send(message);
        } catch (MailException exception) {
            //log the message and go on…
            System.err.println(exception.getMessage());
        }
    }
}
