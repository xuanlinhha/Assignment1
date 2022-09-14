package org.example.storage;

import org.example.model.Dealer;
import org.example.model.Delivery;
import org.example.model.User;

import java.util.List;
import java.util.Map;

public class DB {
    private List<User> users;
    private Map<String, User> usersMap;
    private List<Dealer> dealers;
    private List<Delivery> deliveries;
    public DB() {}

    public DB(List<User> users, Map<String, User> usersMap, List<Dealer> dealers, List<Delivery> deliveries) {
        this.users = users;
        this.usersMap = usersMap;
        this.dealers = dealers;
        this.deliveries = deliveries;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void setUsersMap(Map<String, User> usersMap) {
        this.usersMap = usersMap;
    }

    public List<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
