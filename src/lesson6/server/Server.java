package lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Ожидание подключения...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено!");

            new Thread(() -> {
                try {
                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    while (true) {
                        String message = in.readUTF();
                        System.out.println("Сообщение пользователя: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                    Scanner in = new Scanner(System.in);

                    while (true) {
                        String message = in.nextLine();
                        System.out.println("Сообщение сервера: " + message);
                        out.writeUTF(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Порт уже занят");
        }
    }
}
