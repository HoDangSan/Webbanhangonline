package com.hodangsan.webbanhang.entity;

import com.hodangsan.webbanhang.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Employee extends DBConnection {
    private int idemployees;
    private String employeesName;
    private String address;
    private String phone;
    private String sex;
    private String position;
    private int salary;
    private int revenueTargets;
    private int iduser;

    public Employee() {
    }

    public Employee(int idemployees, String employeesName, String address, String phone, String sex, String position, int salary, int revenueTargets, int iduser) {
        this.idemployees = idemployees;
        this.employeesName = employeesName;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
        this.revenueTargets = revenueTargets;
        this.iduser = iduser;
    }

    public int getIdemployees() {
        return idemployees;
    }

    public void setIdemployees(int idemployees) {
        this.idemployees = idemployees;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getRevenueTargets() {
        return revenueTargets;
    }

    public void setRevenueTargets(int revenueTargets) {
        this.revenueTargets = revenueTargets;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> listEmployee = new ArrayList<Employee>();

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        String sql = "SELECT idemployees,employeesName,address,phone,sex,position,salary,revenueTargets,iduser FROM banhangonlinedb.employees";

        //Tạo đường dẫn kết nối tới CSDL
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // region Thực thi stmt & lấy kết quả SELECT
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idemployees = resultSet.getInt("idemployees");
                String employeesName = resultSet.getString("employeesName");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String sex = resultSet.getString("sex");
                String position = resultSet.getString("position");
                int salary = resultSet.getInt("salary");
                int revenueTargets = resultSet.getInt("revenueTargets");
                int iduser = resultSet.getInt("iduser");
                Employee employee = new Employee(idemployees, employeesName, address, phone, sex, position, salary, revenueTargets, iduser);

                listEmployee.add(employee);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEmployee;
    }
}
