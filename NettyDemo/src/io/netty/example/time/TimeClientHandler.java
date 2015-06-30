package io.netty.example.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/30/2015
 * Email: billchen01@163.com
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf m =(ByteBuf)msg;
        try{
            long currentTimeMills = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMills));
            ctx.close();
        }finally {
            m.release();
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
