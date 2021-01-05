package com.urunov.telgram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TalkingYou extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "TalingwithYoubot";
    }

    @Override
    public String getBotToken() {
        return "1564972202:AAGknXX1SX21s7lzXrcCZq1Cb3MFrDTAz6E";
    }

    @Override
    public void onUpdateReceived(Update update) {

//        System.out.println(update.getMessage().getText());
//        System.out.println(update.getMessage().getFrom().getFirstName());

        SendMessage message = new SendMessage();

        String comman = update.getMessage().getText();

        if(comman.equals("/myname")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }
        if(comman.equals("/mylastname")){
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if(comman.equals("/myfullname")){
            System.out.println(update.getMessage().getFrom().getFirstName() + "  "  + update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }

        if(comman.equals("/myusername")){
            System.out.println(update.getMessage().getFrom().getUserName());
            message.setText(update.getMessage().getFrom().getUserName());
        }
        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        }catch (TelegramApiException el){
            el.printStackTrace();
        }
    }
}
