package edu.citytech.cst.s23826271.firstdynamicweb.repository;

import com.jbbwebsolutions.helper.EnvironmentUtility;
import edu.citytech.cst.s23826271.firstdynamicweb.model.Salary;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryRepo {

    private static final String connectionString = EnvironmentUtility.get("CST_4713_DB"); //"jdbc:derby:/summer2021/payroll/";
    private static final String sqlInserts ="insert into app.employeeSalaries (id,salary,code) values (?,?,?)";
    private static final String sqlSelects ="select * from app.employeeSalaries";
    private static final String fileName = EnvironmentUtility.get("CST_4713_DATA")+"Salaries.csv";

    public static List<Salary> getSalaries() throws IOException {
        List<Salary> list = new ArrayList<>();

        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();//skip the first line
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(SalaryMap(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public static Salary SalaryMap(String rowData){
        Salary salary = new Salary();
        String [] dataRow = rowData.split(",");

        salary.setId(dataRow[0]);
        salary.setSalary(Float.parseFloat(dataRow[1]));
        salary.setStatusCode(dataRow[2]);

        return salary;
    }

    public static boolean insertSalaryIntoDerby(Salary s) throws SQLException {
        Connection connection = DriverManager.getConnection(connectionString);
        PreparedStatement ps = connection.prepareStatement(sqlInserts);

        ps.setString(1,s.getId());
        ps.setFloat(2,s.getSalary());
        ps.setString(3,s.getStatusCode());

        if(ps.executeUpdate()==1)
            return true;

        ps.close();
        connection.close();

        return false;
    }

    public static List<Salary> salaries() throws SQLException {
        List<Salary> list = new ArrayList<>();
        Connection connection = DriverManager.getConnection(connectionString);
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sqlSelects);

        while (rs.next()){
            Salary s = new Salary();
            s.setId(rs.getString("id"));
            s.setSalary(rs.getFloat("salary"));
            s.setStatusCode(rs.getString("code"));
            list.add(s);
        }
        return list;
    }
}
