package com.example.vuespring;

import java.sql.*;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Fail.fail;


@Log4j
public class JDBCTests {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:orcl",
                "RIGUN", "4238")) {
            System.out.println(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
    
