package org.example.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.App;
import org.example.model.Dealer;
import org.example.model.Status;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealerReader {
    public static List<Dealer> read(String file) throws IOException {
        InputStream is = App.class.getClassLoader().getResourceAsStream("dealers.csv");
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Dealer> dealers = new ArrayList<>();
        try {
            dealers = read(reader);
//            System.out.println(dealers);
        } catch (IOException e) {
            System.out.println("Cannot parser dealers.csv");
            e.printStackTrace();
        }
        return dealers;
    }
    public static List<Dealer> read(Reader in) throws IOException {
        List<Dealer> dealers = new ArrayList<Dealer>();
        CSVFormat format = CSVFormat.Builder.create().setDelimiter('|').setHeader("ID", "Name", "Address", "Phone", "Status").setSkipHeaderRecord(true).build();
        Iterable<CSVRecord> records = format.parse(in);
        for (CSVRecord record : records) {
            Status status = Status.valueOf(record.get(4).toUpperCase());
            Dealer dealer = new Dealer(record.get(0), record.get(1), record.get(2), record.get(3), status);
            dealers.add(dealer);
        }
        return dealers;
    }
}
