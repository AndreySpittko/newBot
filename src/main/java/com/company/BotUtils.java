package com.company;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BotUtils {
    private BotUtils() {
        // Required private constructor
    }

    public static InlineKeyboardMarkup buildKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButtonYes = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButtonNo = new InlineKeyboardButton();


        List<List<InlineKeyboardButton>> keyboardButton = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        inlineKeyboardButtonYes.setText("Yes");
        inlineKeyboardButtonYes.setCallbackData("yes");

        inlineKeyboardButtonNo.setText("No");
        inlineKeyboardButtonNo.setCallbackData("no");

        row.add(inlineKeyboardButtonYes);
        row.add(inlineKeyboardButtonNo);

        keyboardButton.add(row);

        inlineKeyboardMarkup.setKeyboard(keyboardButton);

        return inlineKeyboardMarkup;
    }
}
