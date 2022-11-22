package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.service.FlooringMasteryPersistenceException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AuditDaoImpl implements AuditDao {
    public static final String AUDIT_FILE = "audit.txt";

    //    @Override
    public void writeAuditEntry(String order) throws FlooringMasteryPersistenceException {
        //implement
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + order);
        out.flush();
    }
}
