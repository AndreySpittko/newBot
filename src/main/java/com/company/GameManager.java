package com.company;

import com.company.Bot.BotManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {

    Timer timer;
    private IGameCallBack callBack;

    private int first, second;
    private  boolean isAnsvered;

    public interface IGameCallBack {
        void oneNewQuestion(int first, int second);

        void onGameOver();
    }

    private GameManager() {
        timer = new Timer();
        isAnsvered = true;
    }

    /**
     * Singleton: thread save class defining singleton for {@link GameManager} class
     */
    private static class Singleton {
        private static GameManager sInstance = new GameManager();

        private Singleton() {
            // Required empty constructor to prevent instantiation
        }
    }

    /**
     * Singleton: getting singleton instance of {@link GameManager} class
     *
     * @return {@link BotManager} instance
     */
    public static GameManager getInstance() {
        return GameManager.Singleton.sInstance;
    }

    public void startGame(IGameCallBack callBack) {
        this.callBack = callBack;
        newQuestion();
    }

    private void newQuestion() {
        isAnsvered = true;
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(!isAnsvered) {
                    gameOver();
                    return;
                }
                Random random = new Random();
                first = random.nextInt(9);
                second = random.nextInt(9);

                GameManager.this.callBack.oneNewQuestion(first, second);
            }
        }, 0, 5000);

    }

    private void gameOver() {
        timer.cancel();
        callBack.onGameOver();
    }

    public void check(int result) {
        if (result == first * second) {
            isAnsvered = true;
            newQuestion();
        } else {
            gameOver();
        }
    }
}
