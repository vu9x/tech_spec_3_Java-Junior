package ru.geekbrains.junior.chat.server;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientManager implements  Runnable{

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket){

        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clients.add(this);
            //TODO: ...
            name = bufferedReader.readLine();
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");

        } catch(IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){

        //Удаление клиента из коллекции
        removeClient();
        try {
            //Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            //Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            //Завершаем работу клиентского сокета
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Удаление клиента из коллекции
     */
    private void removeClient(){
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

    /**
     * Отправка сообщение всем слушателям
     *
     * @param message
     */
    private void broadcastMessage(String message){
        for (ClientManager client: clients){
            try{
                if(isPrivateMessage(message)){
                    String receiver = receiverIs(message);

                    if(client.name.equals(receiver)) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                } else {
                    if (!client.name.equals(name) && message != null) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                }
            }
            catch (Exception e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private boolean isPrivateMessage(String messageFromClient){
        return messageFromClient.contains("@");
    }

    private String receiverIs (String message){

        Pattern pattern = Pattern.compile("@[A-z]*");
        Matcher matcher = pattern.matcher(message);
        matcher.find();

        StringBuilder sb = new StringBuilder(matcher.group(0));
        sb.deleteCharAt(0);

        return sb.toString();
    }

    @Override
    public void run() {
        String messageFromClient;
        while(!socket.isClosed()){
            try {
                //Чтение данных
                messageFromClient = bufferedReader.readLine();
                // Отправка данных всем слушателям
                broadcastMessage(messageFromClient);
            } catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }

        }
    }
}
