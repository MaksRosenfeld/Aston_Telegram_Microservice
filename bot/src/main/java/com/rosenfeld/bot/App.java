package com.rosenfeld.bot;

import com.rosenfeld.configuration.BotConfiguration;
import lombok.Cleanup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws TelegramApiException {
        @Cleanup AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(BotConfiguration.class);
        TelegramBotsApi tba = new TelegramBotsApi(DefaultBotSession.class);
        MyBot bot = ctx.getBean("bot", MyBot.class);
        tba.registerBot(bot);




    }
}
