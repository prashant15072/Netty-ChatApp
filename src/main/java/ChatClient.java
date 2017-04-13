import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.SystemPropertyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by PRASHANT on 4/13/2017.
 */
public class ChatClient {
    String host;
    int port;

    public static void main(String[] args) throws IOException, InterruptedException {
        new ChatClient("localhost",810).run();
    }

    public ChatClient(String host ,int port){
        this.host=host;
        this.port=port;
    }

    public void run() throws InterruptedException, IOException {
        EventLoopGroup workerGroup=new NioEventLoopGroup();

        try{
            Bootstrap b=new Bootstrap()
                    .group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());

            Channel c=b.connect(host,port).sync().channel();
            BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
            while (true){
                c.write(in.readLine()+"\r\n");
            }
        }
        finally {
            workerGroup.shutdownGracefully();
        }
    }
}
