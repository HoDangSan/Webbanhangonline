package com.hodangsan.webbanhang.entity;

import com.hodangsan.webbanhang.jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private int idproduct;
    private String productName;
    private String description;
    private int price;
    private int amount;
    private int importPrice;
    private String importDate;
    private int idproductType;
    private int idproductdesign;
    private int idproducer;
    private String image;

    public Product() {
    }

    public Product(int idproduct, String productName, int price, String image) {
        this.idproduct = idproduct;
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    public Product(String productName, String description,
                   int price, int amount, int importPrice, String importDate,
                   int idproductType, int idproductdesign, int idproducer, String image) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.importPrice = importPrice;
        this.importDate = importDate;
        this.idproductType = idproductType;
        this.idproductdesign = idproductdesign;
        this.idproducer = idproducer;
        this.image = image;
    }

    public Product(int idproduct, String productName, String description,
                   int price, int amount, int importPrice, String importDate,
                   int idproductType, int idproductdesign, int idproducer, String image) {
        this.idproduct = idproduct;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.importPrice = importPrice;
        this.importDate = importDate;
        this.idproductType = idproductType;
        this.idproductdesign = idproductdesign;
        this.idproducer = idproducer;
        this.image = image;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public int getIdproductType() {
        return idproductType;
    }

    public void setIdproductType(int idproductType) {
        this.idproductType = idproductType;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public int getIdproductdesign() {
        return idproductdesign;
    }

    public void setIdproductdesign(int idproductdesign) {
        this.idproductdesign = idproductdesign;
    }

    public int getIdproducer() {
        return idproducer;
    }

    public void setIdproducer(int idproducer) {
        this.idproducer = idproducer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getAllProduct() {
        List<Product> listProduct = new ArrayList<>();

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
        String sql = "SELECT idproduct, productName, description, price, amount," +
                "importPrice, importDate, idproductType, idproductdesign, idproducer, image FROM product";

        // region Thực thi stmt & lấy kết quả SELECT
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String productName = resultSet.getString("productName");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                int importPrice = resultSet.getInt("importPrice");
                String importDate = resultSet.getString("importDate");
                int idproductType = resultSet.getInt("idproductType");
                int idproductdesign = resultSet.getInt("idproductdesign");
                int idproducer = resultSet.getInt("idproducer");
                String image = resultSet.getString("image");

                Product product = new Product(idproduct, productName, description, price, amount,
                        importPrice, importDate, idproductType, idproductdesign, idproducer, image);

                listProduct.add(product);
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

        return listProduct;
    }

    public List<Product> getAllProductByType(int idproductType) {
        List<Product> products = new ArrayList<>();

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
        String sql = "SELECT idproduct, productName, price, image FROM product " +
                "INNER JOIN producttype on product.idproductType = producttype.idproductType " +
                "WHERE producttype.idproductType = " + idproductType + ";";

        // region Thực thi stmt & lấy kết quả SELECT
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String productName = resultSet.getString("productName");
                int price = resultSet.getInt("price");
                String image = resultSet.getString("image");

                Product product = new Product(idproduct, productName, price, image);

                products.add(product);
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
        return products;
    }

    public boolean create(Product product) throws SQLException {
        String sql = "INSERT INTO product (productName,description,price,amount," +
                "importPrice, importDate, idproductType, idproductdesign,idproducer, image) VALUES (?,?,?,?,?,?,?,?,?,?)";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setString(1, product.getProductName());
        statement.setString(2, product.getDescription());
        statement.setInt(3, product.getPrice());
        statement.setInt(4, product.getAmount());
        statement.setInt(5, product.getImportPrice());
        statement.setString(6, product.getImportDate());
        statement.setInt(7, product.getIdproductType());
        statement.setInt(8, product.getIdproductdesign());
        statement.setInt(9, product.getIdproducer());
        statement.setString(10, product.getImage());


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

    public Product getProduct(int id) throws SQLException {
        Product product = null;

        String sql = "SELECT idproduct, productName,description,price,amount," +
                "importPrice, importDate, idproductType, idproductdesign,idproducer," +
                " image FROM product WHERE idproduct = ?";

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
            String productName = resultSet.getString("productName");
            String description = resultSet.getString("description");
            int price = resultSet.getInt("price");
            int amount = resultSet.getInt("amount");
            int importPrice = resultSet.getInt("importPrice");
            String importDate = resultSet.getString("importDate");
            int idproductType = resultSet.getInt("idproductType");
            int idproductdesign = resultSet.getInt("idproductdesign");
            int idproducer = resultSet.getInt("idproducer");
            String image = resultSet.getString("image");

            product = new Product(id, productName, description, price, amount, importPrice, importDate, idproductType, idproductdesign, idproducer, image);
        }
        resultSet.close();
        statement.close();

        return product;
    }

    public boolean edit(Product product) throws SQLException {
        String sql = "UPDATE product SET productName = ?, description = ?," +
                " price = ?, amount = ?, importPrice = ?, importDate = ?," +
                " idproductType = ?, idproductdesign = ?, idproducer = ?, image = ? ";
        sql += " WHERE idproduct = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        statement.setString(1, product.getProductName());
        statement.setString(2, product.getDescription());
        statement.setInt(3, product.getPrice());
        statement.setInt(4, product.getAmount());
        statement.setInt(5, product.getImportPrice());
        statement.setString(6, product.getImportDate());
        statement.setInt(7, product.getIdproductType());
        statement.setInt(8, product.getIdproductdesign());
        statement.setInt(9, product.getIdproducer());
        statement.setString(10, product.getImage());
        statement.setInt(11, product.getIdproduct());

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

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM product where idproduct = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        statement.setInt(1, id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        conn.close();
        return rowDeleted;
    }

    public List<Product> searchProductByName(String nameString) throws SQLException{
        List<Product> productList = new ArrayList<>();

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

        String sql = "SELECT idproduct, productName,description,price," +
                "amount,importPrice, importDate, idproductType, idproductdesign," +
                "idproducer,image FROM product WHERE productName LIKE '%"+ nameString + "%';";

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int idproduct = resultSet.getInt("idproduct");
                String productName = resultSet.getString("productName");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                int importPrice = resultSet.getInt("importPrice");
                String importDate = resultSet.getString("importDate");
                int idproductType = resultSet.getInt("idproductType");
                int idproductdesign = resultSet.getInt("idproductdesign");
                int idproducer = resultSet.getInt("idproducer");
                String image = resultSet.getString("image");

                Product product = new Product(idproduct, productName, description, price, amount,
                        importPrice, importDate, idproductType, idproductdesign, idproducer, image);

                productList.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
}

