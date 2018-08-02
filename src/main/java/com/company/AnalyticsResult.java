package com.company;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnalyticsResult {
    @SerializedName("message_id")
    private String messageId;

    private int status;

    @SerializedName("all_succeeded")
    private boolean allSucceeded;

    private List<AnalyticsResultResponse> responses;

    public String getMessageId() {
        return messageId;
    }

    public int getStatus() {
        return status;
    }

    public boolean isAllSucceeded() {
        return allSucceeded;
    }

    public List<AnalyticsResultResponse> getResponses() {
        return responses;
    }
}
