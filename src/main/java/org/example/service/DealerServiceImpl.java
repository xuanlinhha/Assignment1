package org.example.service;

import org.example.storage.DB;

public class DealerServiceImpl implements DealerService {
    private DB db;

    public DealerServiceImpl(DB db) {
        this.db = db;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
}
