package com.company;

public class WorkManager {

    private static WorkManager workManagerSingleton;

    private WorkManager() {

    }

    public static WorkManager s() {
        if (workManagerSingleton == null) {
            workManagerSingleton = new WorkManager();
        }

        return workManagerSingleton;
    }

}
