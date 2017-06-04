import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by User on 2017/6/2.
 */
public class Client {
    public static void main(String[] args) {
        final NioSocketConnector connector = new NioSocketConnector();
        ConnectFuture connection=null;
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        connector.getSessionConfig().setIdleTime(IdleStatus.WRITER_IDLE,300);
        connector.setDefaultRemoteAddress(new InetSocketAddress("58.251.157.170",10024));

        connector.setHandler(new ClientHandler());
        ConnectFuture connect = connector.connect();
        connect.awaitUninterruptibly();

        connection = connect;

        for(int i = 0; i<10;i++) {
            connection.getSession().write("hello" + i);
        }

    }

}
