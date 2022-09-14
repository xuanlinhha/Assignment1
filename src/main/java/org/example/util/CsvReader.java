package org.example.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.model.Dealer;
import org.example.model.Role;
import org.example.model.Status;
import org.example.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static final String SEPARATOR = "\\|";
//    public static List<Dealer> readUsingApacheCommonCsv(String name) throws IOException {
//        InputStream is = new FileInputStream(name);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        List<Dealer> dealers = new ArrayList<Dealer>();
//        CSVFormat format = CSVFormat.Builder.create().setDelimiter('|').setHeader("ID", "Name", "Address", "Phone", "Status").setSkipHeaderRecord(true).build();
//        Iterable<CSVRecord> records = format.parse(reader);
//        for (CSVRecord record : records) {
//            Status status = Status.valueOf(record.get(4).toUpperCase());
//            Dealer dealer = new Dealer(record.get(0), record.get(1), record.get(2), record.get(3), status);
//            dealers.add(dealer);
//        }
//        return dealers;
//    }

    public static List<Dealer> readDealers(String name) throws IOException {
        Path path = Paths.get(name);
        List<String> lines = Files.readAllLines(path);
        List<Dealer> dealers = new ArrayList<Dealer>();
        boolean firstLine = true;
        for (String line: lines) {
            // skip the first line
            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] comps = line.split(SEPARATOR);
            if (comps.length == 5) {
                Status status = Status.valueOf(comps[4].toUpperCase());
                Dealer dealer = new Dealer(comps[0], comps[1], comps[2], comps[3], status);
                dealers.add(dealer);
            }
        }
        return dealers;
    }

    public static List<User> readUsers(String name) throws IOException {
        Path path = Paths.get(name);
        List<String> lines = Files.readAllLines(path);
        List<User> users = new ArrayList<User>();
        boolean firstLine = true;
        for (String line: lines) {
            // skip the first line
            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] comps = line.split(SEPARATOR);
            if (comps.length == 5) {
                Role role = Role.valueOf(comps[3].toUpperCase());
                Status status = Status.valueOf(comps[4].toUpperCase());
                User user = new User(comps[0], comps[1], comps[2], role, status);
                users.add(user);
            }
        }
        return users;
    }
}
