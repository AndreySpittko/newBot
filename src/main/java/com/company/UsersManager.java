package com.company;

import com.company.comands.Constants;
import com.company.modals.User;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class UsersManager {
    private MongoCollection<Document> mUsersCollection;


    /**
     * Singleton: thread save class defining singleton for {@link UsersManager} class
     */
    private static class Singleton {
        private static UsersManager sInstance = new UsersManager();

        private Singleton() {
            // Required empty constructor to prevent instantiation
        }
    }

    /**
     * Singleton: getting singleton instance of {@link UsersManager} class
     *
     * @return {@link UsersManager} instance
     */
    public static UsersManager getInstance() {
        return UsersManager.Singleton.sInstance;
    }

    private UsersManager() {
        MongoClientURI connectionString = new MongoClientURI(Constants.DB_URL);
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase(connectionString.getDatabase());
        mUsersCollection = database.getCollection("andrii_users");
    }

    /**
     * Adds new user to database if not exists
     *
     * @param message start message received from user. The user info will be retrieved from message
     * @return {@link User} updated user
     */
    public User addUser(Message message) {
        String firstName = message.getChat().getFirstName();
        String lastName = message.getChat().getLastName();
        String username = message.getChat().getUserName();
        long id = message.getChat().getId();

        long found = mUsersCollection.count(new Document("id", Long.toString(id)));
        if (found == 0) {
            Document doc = new Document("firstName", firstName)
                    .append("lastName", lastName)
                    .append("id", Long.toString(id))
                    .append("username", username)
                    .append("highscore", 0)
                    .append("game", 0);

            mUsersCollection.insertOne(doc);
            BotLogger.debug(Constants.TAG, "Added new user '" + username + "' to the database");
        } else {
            BotLogger.debug(Constants.TAG, "User '" + username + "' already exists in database");
        }

        return UsersManager.getInstance().getUser(id);

    }

    /**
     * Retrieves user by given id
     *
     * @param id id of the user to find
     * @return {@link User} object if found, null otherwise
     */
    public User getUser(long id) {
        Document document = mUsersCollection.find(new Document("id", Long.toString(id))).first();
        if (document != null) {
            User user = new Gson().fromJson(document.toJson(), User.class);
            return user;
        } else {
            return null;
        }
    }
}
