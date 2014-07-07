package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestHandler extends Thread {
	private final static Logger log = Logger.getLogger(RequestHandler.class.getName());

	private Socket connection;

	public RequestHandler(Socket connectionSocket) {
		this.connection = connectionSocket;
	}

	public void run() {
		log.log(Level.INFO, "WebServer Thread Created!");
		InputStream is = null;
		OutputStream os = null;

		try {
			is = connection.getInputStream(); // 사용자 요청
			os = connection.getOutputStream(); // 사용자 응답

			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write("Hello World");
			osw.flush();

			connection.close();
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
}