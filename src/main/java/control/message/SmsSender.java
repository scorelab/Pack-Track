package control.message;

import java.util.Map;
import java.util.HashMap;
 
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
/**
 * Class to send SMS
 *
 */
public class SmsSender {
 
    public static final String ACCOUNT_SID = "AC3652d42613ef357f4d672df81424dea4";
    public static final String AUTH_TOKEN = "1e8ca10db88841b1ffef8f3cd760946b";
 
    /**
     * Sends a SMS using Twillo, telephony service. Can be changed according to user's SMS gateway
     * @param to Receiver
     * @param from Twillo phone granted to the account
     * @param txt Message
     * @throws TwilioRestException
     */
    public static void snedSMS(String to, String from, String txt) throws TwilioRestException {
 
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
        Account account = client.getAccount();
 
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", to));
        params.add(new BasicNameValuePair("From", from));
        params.add(new BasicNameValuePair("Body", txt));
        Message sms = messageFactory.create(params);
    }
}