import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

/**
 * Created by PRASHANT on 4/13/2017.
 */
public class ChatClientHandler extends ChannelInboundMessageHandlerAdapter<String>{

    public void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
    }
}
