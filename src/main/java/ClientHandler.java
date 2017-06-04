/**
 * Created by User on 2017/6/2.
 */
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
public class ClientHandler implements IoHandler{
    public void sessionCreated(IoSession ioSession) throws Exception {
        System.out.println("incomming 客户端:  session created !");

    }


    public void sessionOpened(IoSession ioSession) throws Exception {
        System.out.println("incomming 客户端: " + ioSession.getRemoteAddress());
    }


    public void sessionClosed(IoSession ioSession) throws Exception {

    }


    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {

    }


    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {

    }


    public void messageReceived(IoSession ioSession, Object o) throws Exception {
        System.out.println("服务器返回的数据：" + o.toString());
    }


    public void messageSent(IoSession ioSession, Object o) throws Exception {

    }


    public void inputClosed(IoSession ioSession) throws Exception {

    }
}
