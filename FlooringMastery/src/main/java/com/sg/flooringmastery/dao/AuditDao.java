package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.service.FlooringMasteryPersistenceException;

public interface AuditDao {
    public void writeAuditEntry(String order) throws FlooringMasteryPersistenceException;
}
