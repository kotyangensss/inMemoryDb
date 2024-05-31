package org.example;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
    private final Map<Long, Record> accountIndex;
    private final Map<String, Record> nameIndex;
    private final Map<Double, Record> valueIndex;

    public InMemoryDB() {
        accountIndex = new HashMap<>();
        nameIndex = new HashMap<>();
        valueIndex = new HashMap<>();
    }

    // Add a new record
    public void addRecord(Record record) {
        accountIndex.put(record.getAccount(), record);
        nameIndex.put(record.getName(), record);
        valueIndex.put(record.getValue(), record);
    }

    // Remove a record by account
    public void removeRecordByAccount(Long account) {
        Record record = accountIndex.remove(account);
        if (record != null) {
            nameIndex.remove(record.getName());
            valueIndex.remove(record.getValue());
        }
    }

    // Update a record by account
    public void updateRecord(Record record) {
        // Assume account is unique and used for update
        if (accountIndex.containsKey(record.getAccount())) {
            removeRecordByAccount(record.getAccount());
            addRecord(record);
        }
    }

    // Get a record by account
    public Record getRecordByAccount(Long account) {
        return accountIndex.get(account);
    }

    // Get a record by name
    public Record getRecordByName(String name) {
        return nameIndex.get(name);
    }

    // Get a record by value
    public Record getRecordByValue(Double value) {
        return valueIndex.get(value);
    }
}