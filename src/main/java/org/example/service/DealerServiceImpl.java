package org.example.service;

import org.example.model.Dealer;
import org.example.storage.DB;

public class DealerServiceImpl implements DealerService {
    private DB db;

    public DealerServiceImpl(DB db) {
        this.db = db;
    }

    @Override
    public void printAll() {
        if (db.getDealers()!=null) {
            for (Dealer d: db.getDealers()) {
                System.out.println(d.toString());
            }
        }
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
}
