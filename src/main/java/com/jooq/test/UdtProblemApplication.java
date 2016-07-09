package com.jooq.test;

import com.jooq.test.tables.daos.SomeTableDao;
import com.jooq.test.tables.pojos.SomeTable;
import com.jooq.test.udt.pojos.SomeUdt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdtProblemApplication implements CommandLineRunner {

    @Autowired
    private SomeTableDao someTableDao;

    public static void main(String[] args) {
        SpringApplication.run(UdtProblemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SomeUdt someUdt = new SomeUdt(12345);

        SomeTable someTable = new SomeTable();
        someTable.setSomeUdtColumn(someUdt);

        // Attempt to persist DO with UDT leads to "Cannot convert from
        // SomeUdt" exception.
        someTableDao.insert(someTable);
    }
}
