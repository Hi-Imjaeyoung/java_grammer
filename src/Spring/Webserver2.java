package Spring;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 간단한 8080 웹서버 생성
public class Webserver2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("8080 서비스 시작");
            while(true){
                // Socket 객체는 사용자의 client 객체
                try (Socket socket = serverSocket.accept()){
                                        //header
                    String httpRes = "HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=UTF-8\r\n\r\n"
                                // body
                            + "<html><body><h1>Hello world</h1><p>배고픕니다</p></body></html>";
                    socket.getOutputStream().write(httpRes.getBytes("UTF-8"));
                }

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
