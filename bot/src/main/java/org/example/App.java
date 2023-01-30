package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws TelegramApiException {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("appContext.xml");
        TelegramBotsApi tba = new TelegramBotsApi(DefaultBotSession.class);
        MyBot bot = ctx.getBean("bot", MyBot.class);
        bot.check();
        tba.registerBot(bot);


    }
}
