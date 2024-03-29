package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\\r\\n\\r\\n".getBytes());
                    String str = in.readLine();
                    if (str.contains("msg=Hello")) {
                        System.out.println("Hello");
                    }
                    if (str.contains("msg=Exit")) {
                        server.close();
                    }
                    if (str.contains("msg=Any")) {
                        System.out.println("What");
                    }
                    out.flush();
                } catch (Exception e) {
                    LOG.error("Socket I/O exception");
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}