package org.example.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.model.Dealer;
import org.example.model.Status;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DealerParser {
    public static List<Dealer> parser(Reader in) throws IOException {
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
