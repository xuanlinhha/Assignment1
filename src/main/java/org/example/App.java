package org.example;

import org.example.model.Dealer;
import org.example.model.User;
import org.example.program_state.InitialState;
import org.example.program_state.PState;
import org.example.service.*;
import org.example.storage.DB;
import org.example.util.ConfigReader;
import org.example.util.CsvReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        ConfigReader.Config config = ConfigReader.read();
        List<User> users = CsvReader.readUsers(config.userFile);
        Map<String, User> userMap = new HashMap<String, User>();
        for (User user : users) {
            userMap.put(user.getUsername(), user);
        }
        List<Dealer> dealers = CsvReader.readDealers(config.dealerFile);
        DB db = new DB(users, userMap, dealers, null);
        UserService userService = new UserServiceImpl(db);
        DealerService dealerService = new DealerServiceImpl(db);
        ServiceDiscovery.userService = userService;
        ServiceDiscovery.dealerService = dealerService;

        PState state = new InitialState();
        while (true) {
            state = state.run();
        }
    }
}
