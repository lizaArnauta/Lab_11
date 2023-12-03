package Task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MailBox {
    private final List<MailInfo> mailInformation = new ArrayList<>();


    public void addMailInformation(MailInfo information) {
        mailInformation.add(information);
    }

    public void dispatchAllMails() throws MailjetSocketTimeoutException, MailjetException {
        var mailDispatcher = new MailSender();
        for (var information : mailInformation) {
            mailDispatcher.dispatchMail(information);
        }
        mailInformation.clear();
    }

    public Object getInfos() {
        return null;
    }
}
