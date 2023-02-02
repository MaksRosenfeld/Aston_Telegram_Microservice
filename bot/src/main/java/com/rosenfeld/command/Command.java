package com.rosenfeld.command;

import com.rosenfeld.bot.MyBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    String getAnswer(Update update);

    String commandName();

    @Autowired
    default void registerInCommands(MyBot myBot) {
        myBot.registerCommand(this);
    }
}
