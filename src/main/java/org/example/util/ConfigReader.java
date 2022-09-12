package org.example.util;

import org.example.App;

import java.io.*;

public class ConfigReader {

    private static final String CONFIG_FILE = "config.properties";
    private static final String USER_FILE_KEY = "users_file";
    private static final String DEALER_FILE_KEY = "users_file";

    public static Config read() throws IOException {
        InputStream is = App.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        Config config = new Config();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] comps = line.split("=");
            if (comps[0] == USER_FILE_KEY) {
                config.userFile = comps[1];
            } else if (comps[0] == DEALER_FILE_KEY) {
                config.dealerFile = comps[1];
            }
        }
        return config;
    }

    public static class Config {
        public String userFile;
        public String dealerFile;
        public String deliveryFile;
    }
}
