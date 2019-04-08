package com.example.demo.webSocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {

    //用来记录当前在线连接数。应该设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket
    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();

    //与某个客户端的链接回话，需要通过她给客户端发送数据
    private Session session;

    /**
     * 链接建立成功会执行此方法
     * */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
        addOnlineCount();
        System.out.println("有新链接加入！当前在线人数为"+getOnlineCount());
        try{
            sendMessage("test");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("异常");
        }
    }

    /**
     * 链接关闭的时候调用
     * */
    @OnClose
    public void onClose(){
        webSockets.remove(this);
        subOnlineCount();
        System.out.println("有一个链接关闭！当前在现在人数"+getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息"+message);

        //群发消息
        for(MyWebSocket item:webSockets){
            try{
                item.sendMessage(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 当发生错误时调用
     * */
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("错误");
        error.printStackTrace();
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message) throws IOException {
        for (MyWebSocket item : webSockets) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    private static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    private void sendMessage(String test) throws IOException {
        this.session.getBasicRemote().sendText(test);
    }

    private static synchronized int  getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

}
