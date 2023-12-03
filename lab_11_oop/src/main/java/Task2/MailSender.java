package Task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {
    public void dispatchMail(MailInfo information) throws MailjetSocketTimeoutException, MailjetException {
        MailjetClient mailjetClient;
        MailjetRequest mailjetRequest;
        MailjetResponse mailjetResponse;

        mailjetClient = new MailjetClient("API_KEY", "API_SECRET_KEY", new ClientOptions("v3.1"));
        mailjetRequest = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", information.getClient().getName() + "@gmail.com")
                                        .put("Name", information.getClient().getName()))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "recipient@example.com")
                                                .put("Name", "Recipient Name")))
                                .put(Emailv31.Message.SUBJECT, "ID: " + information.getClient().getId() + " Age: " + information.getClient().getAge() + " Sex: " + information.getClient().isSex())
                                .put(Emailv31.Message.TEXTPART, "Mail")
                                .put(Emailv31.Message.HTMLPART, "<h3>Dear recipient, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
                                .put(Emailv31.Message.CUSTOMID, "CustomIDForTest")));
        mailjetResponse = mailjetClient.post(mailjetRequest);

        System.out.println(mailjetResponse.getStatus());
        System.out.println(mailjetResponse.getData());
    }
}
