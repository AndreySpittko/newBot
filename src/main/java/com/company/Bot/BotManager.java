package com.company.Bot;

import com.company.comands.Constants;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class BotManager {

    private TachDemomyBot bot;


    /**
     * Singleton: thread save class defining singleton for {@link BotManager} class
     */
    private static class Singleton {
        private static BotManager sInstance = new BotManager();
        private Singleton() {
            // Required empty constructor to prevent instantiation
        }
    }

    /**
     * Singleton: getting singleton instance of {@link BotManager} class
     * @return {@link BotManager} instance
     */
    public static BotManager getInstance() {
        return BotManager.Singleton.sInstance;
    }

    private BotManager() {
        // Required private constructor
    }

    public void setBot(TachDemomyBot bot) {
        if (this.bot == null) {
            this.bot = bot;
        } else {
            BotLogger.error(Constants.TAG, "WARNING: Second try to set bot!");
        }
    }

    public TachDemomyBot getBot() {
        return bot;
    }
    public void handlStartCommand(SendMessage sendMessage) {
    }

}
