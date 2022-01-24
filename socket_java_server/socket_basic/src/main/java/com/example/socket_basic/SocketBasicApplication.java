package com.example.socket_basic;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketBasicApplication.class, args);

        try {
            socketSetup();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    private static void socketSetup() throws InterruptedException {

        Configuration config = new Configuration();
//        config.setHostname("localhost");
        config.setPort(6000);

        final SocketIOServer server = new SocketIOServer(config);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("Conectadooooooooooo");
            }
        });


/*        server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
//                server.getBroadcastOperations().sendEvent("chatevent", data);
                System.out.println("chatevent");
            }
        });*/

        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }

}
