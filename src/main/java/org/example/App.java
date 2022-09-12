package org.example;

import org.example.model.Dealer;
import org.example.util.ConfigReader;
import org.example.util.DealerReader;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ConfigReader.Config config = ConfigReader.read();
        List<Dealer> dealers = DealerReader.read(config.dealerFile);
        System.out.println(dealers);
    }
}
