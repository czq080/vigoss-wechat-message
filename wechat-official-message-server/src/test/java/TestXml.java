import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.factory.MessageKey;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.type.EncryptType;
import com.vigoss.wechat.core.xml.MessageTransfer;
import com.vigoss.wechat.core.xml.MessageTransferHandler;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import java.util.concurrent.CountDownLatch;

/**
 * @author chenzhiqiang
 * @date 2018/7/19
 */
public class TestXml {

    @Test
    public void test() throws InterruptedException {
        MessageRequest request = new MessageRequest();
        request.setMsgSignature("ac8f47893fc7f9ab053701f127c1f839a2b3239f");
        request.setEncryptType(EncryptType.CIPHERTEXT);
        request.setEncryptContent(null);
        request.setAgentId("4");
        request.setAppId("wxef20891dffeb6d1d");
        request.setEchostr(null);
        request.setNonce("1532469958");
        request.setSignature(null);
        request.setType(WechatAccountType.ENTERPRISE);
        request.setTimestamp("1531980246");
        String xml = "";
        request.setOriginalContent(xml);
        MessageRequest request2 = new MessageRequest();
        request2.setMsgSignature("e992d4fe8e198ec3c458c26bb48030f498530e42");
        request2.setEncryptType(EncryptType.CIPHERTEXT);
        request2.setEncryptContent(null);
        request2.setAgentId("4");
        request2.setAppId("wxef20891dffeb6d1d");
        request2.setEchostr(null);
        request2.setNonce("1532947008");
        request2.setType(WechatAccountType.ENTERPRISE);
        request2.setSignature(null);
        request2.setTimestamp("1531980246");
        String xml1 = "";
        request2.setOriginalContent(xml1);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread xx = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MessageTransfer messageTransfer = MessageTransferHandler.parser(request);
                MessageKey messageKey = defineMessageKey(messageTransfer);
                System.out.println(messageKey);
            }
        });

        Thread xx1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MessageTransfer messageTransfer1 = MessageTransferHandler.parser(request2);
                MessageKey messageKey1 = defineMessageKey(messageTransfer1);
                System.out.println(messageKey1);
            }
        });
        xx.start();
        xx1.start();
        Thread.sleep(1000);
        countDownLatch.countDown();
        countDownLatch.countDown();
        Thread.sleep(20000);
    }
    private MessageKey defineMessageKey(MessageTransfer messageTransfer) {
        return new MessageKey(
                messageTransfer.getMsgType(), messageTransfer.getEventType(),
                messageTransfer.getAccountType());
    }
}
