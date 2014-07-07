package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WebServer {

	private final static Logger log = Logger.getLogger(WebServer.class.getName());

    public static void main(String argv[]) throws Exception {
        // ���������� �����Ѵ�. �������� �⺻������ 80�� ��Ʈ�� ����Ѵ�.
        ServerSocket listenSocket = new ServerSocket(80);
        log.log(Level.INFO, "WebServer Socket Created");

        // Ŭ���̾�Ʈ�� ����ɶ����� ����Ѵ�.
        Socket connection;
        while ((connection = listenSocket.accept()) != null) {
        	RequestHandler requestHandler = new RequestHandler(connection);
            requestHandler.start();
        }
    }
}