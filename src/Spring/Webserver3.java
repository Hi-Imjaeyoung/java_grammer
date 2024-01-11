package Spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Webserver3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("8080 서비스 시작");

            // header
//                POST/ HTTP/1.1
//                Host: localhost:8080
//                Content-Type: application/x-www-form-urlencoded // form tag기본 content-type
//                Content-Length: xx

            // body
//                userInput=helloworld

            while(true){
                try (Socket socket = serverSocket.accept()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line="";
                    while (!(line= br.readLine()).isBlank()){
                        sb.append(line+"\n");
                    }

                    if(sb.toString().contains("POST")){
                        char[] buffer = new char[1024];
                        br.read(buffer);
                        System.out.println("POST body data : " +new String(buffer));
                        System.out.println("POST header data : " +sb.toString());
                    }
                    String httpRes = "HTTP/1.1 200 OK\r\n\r\n" + "Ok";
                    socket.getOutputStream().write(httpRes.getBytes("UTF-8"));
                }

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
