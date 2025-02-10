import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ModifiedHTTPServer {


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening on port 8080......");

        while (true) {
            try (Socket socket = server.accept()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = reader.readLine();

                String url = "";
                if (line != null && line.startsWith("GET")){
                    url = line.split(" ")[1];

                }

                String httpResponse = "";
                if (url.equals("/date")) {
                    httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + Utils.getCurrentDate();
                } else if (url.equals("/hello")) {
                    httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + Utils.getMessage();
                } else {
                    httpResponse = "HTTP/1.1 404 Not Found\r\n\r\nPage not found!";
                }
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}