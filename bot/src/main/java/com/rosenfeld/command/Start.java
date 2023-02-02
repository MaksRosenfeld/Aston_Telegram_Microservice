package com.rosenfeld.command;

import com.rosenfeld.bot.MyBot;
import com.rosenfeld.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Start implements Command {

    @Override
    public String getAnswer(Update update) {
        String firstName = update.getMessage().getChat().getFirstName();
        return String.format("Hello %s", firstName);
    }

    @Override
    public String commandName() {
        return "/start";
    }

}
