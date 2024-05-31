package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryDBTest {
    private InMemoryDB db;

    @BeforeEach
    void setUp() {
        db = new InMemoryDB();
    }

    @Test
    void testAddRecord() {
        Record record = new Record(234678L, "Иванов Иван Иванович", 2035.34);
        db.addRecord(record);

        Assertions.assertEquals(record, db.getRecordByAccount(234678L));
        Assertions.assertEquals(record, db.getRecordByName("Иванов Иван Иванович"));
        Assertions.assertEquals(record, db.getRecordByValue(2035.34));
    }

    @Test
    void testRemoveRecordByAccount() {
        Record record = new Record(123456L, "Петров Петр Петрович", 1500.00);
        db.addRecord(record);
        db.removeRecordByAccount(123456L);

        Assertions.assertNull(db.getRecordByAccount(123456L));
        Assertions.assertNull(db.getRecordByName("Петров Петр Петрович"));
        Assertions.assertNull(db.getRecordByValue(1500.00));
    }

    @Test
    void testUpdateRecord() {
        Record record = new Record(345678L, "Сидоров Сидор Сидорович", 3000.50);
        db.addRecord(record);

        Record updatedRecord = new Record(345678L, "Сидоров Сидор Сидорович", 3500.75);
        db.updateRecord(updatedRecord);

        Assertions.assertEquals(updatedRecord, db.getRecordByAccount(345678L));
        Assertions.assertEquals(updatedRecord, db.getRecordByName("Сидоров Сидор Сидорович"));
        Assertions.assertEquals(updatedRecord, db.getRecordByValue(3500.75));
    }

    @Test
    void testGetRecordByAccount() {
        Record record = new Record(567890L, "Алексеев Алексей Алексеевич", 4000.00);
        db.addRecord(record);

        Assertions.assertEquals(record, db.getRecordByAccount(567890L));
    }

    @Test
    void testGetRecordByName() {
        Record record = new Record(678901L, "Федоров Федор Федорович", 4500.00);
        db.addRecord(record);

        Assertions.assertEquals(record, db.getRecordByName("Федоров Федор Федорович"));
    }

    @Test
    void testGetRecordByValue() {
        Record record = new Record(789012L, "Николаев Николай Николаевич", 5000.00);
        db.addRecord(record);

        Assertions.assertEquals(record, db.getRecordByValue(5000.00));
    }
}
