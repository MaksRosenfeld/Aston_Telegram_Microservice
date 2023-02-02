package com.rosenfeld.mentor;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class DBTest {

    @Container
    private PostgreSQLContainer psc = new PostgreSQLContainer<>("postgres:11.1")
            .withInitScript("/resources/init_script.sql")
            .withInitScript("/resources/fulfill.sql");


}
