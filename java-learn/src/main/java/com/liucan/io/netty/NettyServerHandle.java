package com.liucan.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liucan
 * @version 19-3-17
 */
public class NettyServerHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
        result.readBytes(result1);
        // 释放资源，这行很关键
        result.release();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Java_apiCopy.rar", true);
        saveDisk(fileOutputStream, result1);

        sendMsg(ctx);
    }

    // 写入本地磁盘
    private void saveDisk(FileOutputStream fileOutputStream, byte[] bytes) throws IOException {
        fileOutputStream.write(bytes, 0, bytes.length);
        fileOutputStream.close();
    }

    // 向客户端发送消息
    private void sendMsg(ChannelHandlerContext ctx) {
        String response = "OK BYTES NettyClient!";
        // 发送的数据必须转换成ByteBuf字节数据数组,进行传输
        ByteBuf encoded = ctx.alloc().buffer(response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
