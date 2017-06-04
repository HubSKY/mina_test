import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

/**
 * Created by User on 2017/6/4.
 */
public class ServerHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        cause.printStackTrace();
    }

    /*
     * 这个方法是目前这个类里最主要的，
     * 当接收到消息，只要不是quit，就把服务器当前的时间返回给客户端
     * 如果是quit，则关闭客户端连接*/
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String str = message.toString();
        if (str.trim().equalsIgnoreCase("quit")) {
            session.close();
            return;
        }
        Date date = new Date();
        System.out.println("hello"+str+"   :"+session.getRemoteAddress()+date.toString());

        session.write("i am recived : =>"+str);

    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        super.sessionClosed(session);
        System.out.println("客户端与服务端断开连接.....");
    }
}
