package com.rosenfeld.bot;


import com.rosenfeld.command.Command;
import com.rosenfeld.command.UnknownCommand;
import com.rosenfeld.configuration.BotConfiguration;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

@Component("bot")
@Getter
public class MyBot extends TelegramLongPollingBot {

    private Map<String, Command> commands = new HashMap<>();

    private final BotConfiguration botConfiguration;

    @Autowired
    public MyBot(BotConfiguration botConfiguration) {
        this.botConfiguration = botConfiguration;
    }
    @Override
    public String getBotUsername() {
        return botConfiguration.getUserName();
    }

    @Override
    public String getBotToken() {
        return botConfiguration.getToken();
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String receivedText = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(chatId);
            String answer = commands
                    .getOrDefault(receivedText, commands.get("unknown"))
                    .getAnswer(update);
            WebClient wc = WebClient.builder().baseUrl("http://my-tomcat:8080/ms1").build();
            String answerAPI = wc
                    .get()
                    .uri("/api/check")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            message.setText(answer + " " + answerAPI);


            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public void registerCommand(Command command) {
        commands.put(command.commandName(), command);
    }

    public void check() {
        System.out.println("I am created");
    }
}