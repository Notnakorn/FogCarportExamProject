
package BusinessLogic.Email;
import BusinessLogic.Customer;
import BusinessLogic.PartList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
* Author Ron, implemented and rewritten by Kasper and Anton 
http://stackoverflow.com/questions/7970827/sending-mail-from-apache-tomcat

*/
public class SendMail {

    public void sendEmail(PartList pl, Customer c) {

        final String username = "testmailfog@gmail.com";
        final String password = "fogtest1234";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testmailfog@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("testmailfog@gmail.com"));
            message.setSubject("Bestilling fra " + c.getCustomerName());
            message.setText("Bestilling fra kunde: " + c.getCustomerName()
                    + "\nKundes telefonnummber: " + c.getCustomerPhoneNumber()
                    + "\nKundes email: " + c.getCustomerEmail()
                + "\n\n"+pl.toString()
                + "\n\n Levering til: " + c.getCustomerAdress());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}