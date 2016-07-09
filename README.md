# JOOQ + PostgreSQL + DAO = exception

Sample application that demonstrates problem with persisting generated POJO with UDT column by DAO.

## Getting started

1. Create PostgreSQL schema from `schema.sql` file. Just run `psql < schema.sql` as a superuser.
2. Generate JOOQ classes by `gradle generateDomainObjects`
3. Run the application by `gradle bootRun`. Or just open it in your favourie editor and run `UdtProblemApplication.main` method.
4. Observe the exception.
    ````
    Caused by: org.jooq.exception.DataTypeException: Cannot convert from SomeUdt (12345) (class com.jooq.test.udt.pojos.SomeUdt) to class com.jooq.test.udt.records.SomeUdtRecord
    	at org.jooq.tools.Convert$ConvertAll.fail(Convert.java:1113) ~[jooq-3.8.3.jar:na]
    ````