package com.rosenfeld.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UnknownCommand implements Command{
    @Override
    public String getAnswer(Update update) {
        return "Now I don't know this command";
    }

    @Override
    public String commandName() {
        return "unknown";
    }
}
