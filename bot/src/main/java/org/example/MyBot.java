package org.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component("bot")
public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "junior_helper_bot";
    }

    @Override
    public String getBotToken() {
        return "5943774149:AAGGVbO-b53rB_SAn3_VHZBV00NUtBN-Qug";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String receivedText = update.getMessage().getText();
            String firstName = update.getMessage().getChat().getFirstName();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(chatId);
            WebClient wc = WebClient.builder().baseUrl("http://my-tomcat:8080/ms1").build();
            String answer = wc
                    .get()
                    .uri("/api/check")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            if ("/start".equals(receivedText)) {
                message.setText("Hello " + firstName);
            } else {
                message.setText("I don't know this command yet! But here is data from API\n" + answer);
            }

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public void check() {
        System.out.println("I am created");
    }
}