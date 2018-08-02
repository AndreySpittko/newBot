package com.company.Bot;

import com.company.GameManager;
import com.company.UsersManager;
import com.company.modals.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Random;

public class TachDemomyBot extends TelegramLongPollingBot {       // point 2

    private final String API = "622205611:AAEzGi9_s9TzWkuhaVZIato0NvWy3iv3tVY";
    private final String CIVIL_BOT = "My bot";
    private String db = "mongodb://java2:monkey2@ds241121.mlab.com:41121/heroku_sbfcgdq8";


    @Override
    public void onUpdateReceived(Update update) {
        process(update);
    }

    /**
     *
     * @param update
     */
    private void process(Update update) {
        if(update.hasMessage()) {
            process(update.getMessage());
        } else if(update.hasCallbackQuery()) {
            process(update.getCallbackQuery());
        }
    }

    /**
     *
     * @param message
     */
    private void process(Message message) {
        long chatId = message.getChatId();

        SendMessage sendMessage = new SendMessage().setChatId(chatId);

        String text = message.getText();

        String reply = text;

        // TODO: Add handling

        if(text.equalsIgnoreCase("/start")) {
            showBotIsTyping(chatId);

            User user = UsersManager.getInstance().addUser(message);

            reply = "Total games: " + user.getGame() + "\n" + "Highscore: " + user.getHighscore();
            sendMessage.setText(reply);

            execute(sendMessage);
        } else if (text.equalsIgnoreCase("/play")) {
            GameManager.getInstance().startGame(new GameManager.IGameCallBack() {
                @Override
                public void oneNewQuestion(int first, int second) {
                    sendMessage.setText(first + "*" + second + "=?");
                    execute(sendMessage);
                }

                @Override
                public void onGameOver() {
                    sendMessage.setText("DNO!");
                    execute(sendMessage);
                }
            });
        } else {
            GameManager.getInstance().check(Integer.valueOf(text));
        }
    }

    /**
     *
     * @param callbackQuery
     */
    private void process(CallbackQuery callbackQuery) {
        // TODO: Add handLine of call back query
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            process(update);
        }
    }

    @Override
    public String getBotUsername() {
        return CIVIL_BOT;
    }

    @Override
    public String getBotToken() {
        return API;
    }


    /**
     * Wrapper for execute method
     *
     * @param sendMessage {@link SendMessage} to be sent to user
     */
    private void execute(SendMessage sendMessage) {
        try {
            super.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param chatId id of the chat to respond in
     */
    private  void showBotIsTyping(long chatId) {
        try {
            execute(new SendChatAction(chatId, "typing"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
