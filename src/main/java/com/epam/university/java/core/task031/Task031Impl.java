package com.epam.university.java.core.task031;

import java.util.ArrayList;

public class Task031Impl implements Task031 {
    ArrayList<String> messages = new ArrayList<>();

    /**
     * Create chat client.
     *
     * @return chat client instance
     */
    @Override
    public Client createClient() {
        return new Client() {
            @Override
            public void sendMessage(String message) {
                messages.add(message);
            }

            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        };
    }

    /**
     * Create chat server.
     *
     * @return chat server instance
     */
    @Override
    public Server createServer() {
        return new Server() {

            /**
             * Read last received message.
             *
             * @return message text
             */
            @Override
            public String readMessage() {
                if (messages.size() == 0) {
                    return "";
                }
                String message = messages.get(messages.size() - 1);
                messages.remove(messages.size() - 1);
                return message;
            }

            /**
             * Start chat server.
             */
            @Override
            public void start() {

            }

            /**
             * Stop chat server.
             */
            @Override
            public void stop() {

            }
        };
    }
}
