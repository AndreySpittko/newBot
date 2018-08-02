package com.company;

import com.google.gson.annotations.SerializedName;

public class AnalyticsResultResponse {
    @SerializedName("message_id")
    private long messageId;

    private String status;

    public long getMessageId() {
        return messageId;
    }

    public String getStatus() {
        return status;
    }
}
