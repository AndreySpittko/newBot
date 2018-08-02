package com.company.comands;

public final class Constants {

    private Constants() {
    }

        /*
         * Analytics API constants
         */
        public static final String ANALYTICS_BASE_API_URL = "https://chatbase.com/api/";
        public static final String ANALYTICS_API_TOKEN = "ee95e603-067f-4d21-b62b-1d3a08c29b5b";
        public static final String TELEGRAM = "Telegram";

        public static final  String TAG = "Telegram bot tachDemoBot";

        /*
         * Bot constants
         */
        public static final String BOT_ACCESS_TOKEN = "622205611:AAEzGi9_s9TzWkuhaVZIato0NvWy3iv3tVY";
        public static final String BOT_NAME = "Exchange Bot";
        public static final String BOT_VERSION = "1.0";

        /*
         * Database constants
         */
        private static final String DB_REMOTEHOST = "ds111192.mlab.com";
        private static final int DB_REMOTEHOST_PORT = 11192;
        private static final String DB_NAME_REMOTE = "heroku_f4cg1nx2";

        private static final String DB_HOST = DB_REMOTEHOST;
        private static final int DB_PORT = DB_REMOTEHOST_PORT;
        private static final String DB_NAME = DB_NAME_REMOTE;
        private static final String DB_USER = "andrii";
        private static final String DB_PASSWORD = "Andrii1";

        public static final String DB_URL = "mongodb://" + DB_USER + ":" + DB_PASSWORD + "@" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

}
