package com.company;

import com.company.comands.Constants;
import com.google.gson.annotations.SerializedName;

public class AnalyticsMessage {
    public AnalyticsMessage() {
        apiKey = Constants.ANALYTICS_API_TOKEN;
        platform = Constants.TELEGRAM;
        version = Constants.BOT_VERSION;
    }

    @SerializedName("api_key")
    private String apiKey;

    private String type;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("time_stamp")
    private long timestamp;

    private String platform;

    private String message;

    private String intent;

    @SerializedName("not_handled")
    private boolean notHandled;

    private String version;

    @SerializedName("session_id")
    private String sessionId;

    public void setType(String type) {
        this.type = type;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public void setNotHandled(boolean notHandled) {
        this.notHandled = notHandled;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
