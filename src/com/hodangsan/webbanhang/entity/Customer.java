package com.hodangsan.webbanhang.entity;

import com.hodangsan.webbanhang.jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer extends DBConnection {
    private int idcustomer;
    private String customerName;
    private String sex;
    private String phone;
    private int iduser;

    public Customer() {
    }

    public Customer(int idcustomer, String customerName, String sex, String phone, int iduser) {
        this.idcustomer = idcustomer;
        this.customerName = customerName;
        this.sex = sex;
        this.phone = phone;
        this.iduser = iduser;
    }

    public int getIdcustomer() {
        return idcustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public List<Customer> getAllCustomer() {
        // Tạo một mảng chứa danh sách các khách hàng
        List<Customer> listCustomer = new ArrayList<Customer>();

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        //Tạo đường dẫn kết nối tới CSDL
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Câu lệnh truy vấn SQL
        String sql = "SELECT idcustomer, customerName, sex, phone, iduser FROM customer";

        // region Thực thi stmt & lấy kết quả SELECT
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idcustomer = resultSet.getInt("idcustomer");
                String customerName = resultSet.getString("customerName");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                int iduser = resultSet.getInt("iduser");
                Customer customer = new Customer(idcustomer, customerName, sex, phone, iduser);

                listCustomer.add(customer);
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

        return listCustomer;
    }

    public boolean create(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (customerName,sex,phone,iduser) VALUES (?,?,?,?)";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        statement.setString(1, customer.getCustomerName());
        statement.setString(2,customer.getSex());
        statement.setString(3,customer.getPhone());
        statement.setInt(4,customer.getIduser());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public Customer getcustomer(int id) throws SQLException {
        Customer customer = null;
        String sql = "SELECT idcustomer, customerName, sex, phone, iduser FROM customer WHERE idcustomer = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            String customerName = resultSet.getString("customerName");
            String sex = resultSet.getString("sex");
            String phone = resultSet.getString("phone");
            int iduser = resultSet.getInt("iduser");

            customer = new Customer(id, customerName, sex, phone, iduser);
        }
        resultSet.close();
        statement.close();

        return customer;
    }

    public boolean edit(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET customerName = ?, sex = ?, phone = ?, iduser = ?";
        sql += " WHERE idcustomer = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        statement.setString(1, customer.getCustomerName());
        statement.setString(2,customer.getSex());
        statement.setString(3,customer.getPhone());
        statement.setInt(4,customer.getIduser());
        statement.setInt(5,customer.getIdcustomer());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public boolean delete(Customer customer) throws SQLException {
        String sql = "DELETE FROM customer where idcustomer = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        statement.setInt(1, customer.getIdcustomer());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        conn.close();
        return rowDeleted;
    }

}
