package org.example;

import org.example.model.Dealer;
import org.example.util.DealerParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InputStream is = App.class.getClassLoader().getResourceAsStream("dealers.csv");
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        try {
            List<Dealer> dealer = DealerParser.parser(reader);
            System.out.println(dealer);
        } catch (IOException e) {
            System.out.println("Cannot parser dealers.csv");
            e.printStackTrace();
        }
    }
}
