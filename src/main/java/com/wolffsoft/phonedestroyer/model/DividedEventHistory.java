package com.wolffsoft.phonedestroyer.model;

import com.wolffsoft.phonedestroyer.model.event.EventHistory;

import java.util.ArrayList;
import java.util.List;

public class DividedEventHistory {

    private List<EventHistory> eventHistoryElders = new ArrayList<>();
    private List<EventHistory> eventHistoryMembers = new ArrayList<>();

    public void addForElders(EventHistory eventHistory) {
        eventHistoryElders.add(eventHistory);
    }

    public void addForMembers(EventHistory eventHistory) {
        eventHistoryMembers.add(eventHistory);
    }

    public List<EventHistory> getEventHistoryElders() {
        return eventHistoryElders;
    }

    public List<EventHistory> getEventHistoryMembers() {
        return eventHistoryMembers;
    }
}
