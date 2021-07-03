package edu.citytech.cst.s23826271.firstdynamicweb.salary;

import com.jbbwebsolutions.helper.EnvironmentUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@DisplayName("TestConnection 1")
public class T1_TestConnection {

    static final String connection =  EnvironmentUtility.get("CST_4713_DB");
    static final String sqlInserts = "insert into app.employeeSalaries (id,salary,code) values (?,?,?)";
    static final String fileName = EnvironmentUtility.get("CST_4713_DATA") + "Salaries.csv";


    @DisplayName("(1) test connection")
    @Test
    void T1() throws Exception {
        Connection conn = DriverManager.getConnection(connection);
        System.out.println(conn);
        conn.close();
    }

    @DisplayName("(2) test connection")
    @Test
    void T2() throws Exception {
        Connection conn = DriverManager.getConnection(connection);
        System.out.println(conn);
        conn.close();
    }


    @DisplayName("(5) query Data")
    @Test
    void T5() throws Exception {
        Connection conn = DriverManager.getConnection(connection);

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet crs = factory.createCachedRowSet();
        crs.setCommand("select id,salary,code from app.employeeSalaries");
        crs.execute(conn);

        while(crs.next()) {
            System.out.print(crs.getString("id"));
            System.out.print(crs.getFloat("salary"));
            System.out.println(crs.getString("code"));
        }
        conn.close();
    }
}