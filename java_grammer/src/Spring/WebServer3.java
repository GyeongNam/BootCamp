package Spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("8081 서비스 시작");
            while (true) {
                try (Socket socket = serverSocket.accept()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while (!(line = br.readLine()).isBlank()){
                        sb.append(line+"\n");
                    }
                    if(sb.toString().contains("POST")){
                        char[] buffer = new char[1024];
                        br.read(buffer);
                        System.out.println("POST body data : " + new String(buffer));
                        System.out.println("POST all data : " + sb);
                    }
                    String httpRes = "HTTP/1.1 200 OK \r\n\r\n" + "ok";
                    socket.getOutputStream().write(httpRes.getBytes("UTF-8"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
