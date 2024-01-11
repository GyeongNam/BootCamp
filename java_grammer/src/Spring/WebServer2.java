package Spring;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebServer2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("8081 서비스 시작");
            while (true) {
                // socket 객체는 사용자의 클라이언트 객체다.
                try (Socket socket = serverSocket.accept()){
                    String httpRes =
                            "HTTP/1.1 200 OK \r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n\r\n" +
                            "<html>" +
                                "<body>" +
                                    "<h1> Hello World </h1>"+
                                    "<p> 안녕하세요 여러분 </p>"+
                                "</body>"+
                            "</html>"
                            ;
                    socket.getOutputStream().write(httpRes.getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
