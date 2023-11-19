package lk.ijse.apparelHub.model;

import lk.ijse.apparelHub.db.DbConnection;
import lk.ijse.apparelHub.dto.CustomerDto;
import lk.ijse.apparelHub.dto.OrderDto;
import lk.ijse.apparelHub.dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderModel {

    public boolean saveOrder(OrderDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES(?,?,?, ?,?,?,?)";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(1, dto.getOrderId());
        pstm.setString(2, dto.getB_id());
        pstm.setString(3, dto.getPay_id());
        pstm.setString(4, String.valueOf(dto.getPrice()));
        pstm.setString(5, dto.getDescription());
        pstm.setString(6, String.valueOf(dto.getQty()));
        pstm.setString(7,dto.getDate());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public boolean updateOrder(OrderDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE orders SET B_id = ?, Pay_id = ?, price = ? ,Description = ? ,Qty = ? , Date = ? WHERE OrderId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getB_id());
        pstm.setString(2, dto.getPay_id());
        pstm.setString(3, String.valueOf(dto.getPrice()));
        pstm.setString(4, dto.getDescription());
        pstm.setString(5, String.valueOf(dto.getQty()));
        pstm.setString(6,dto.getDate());
        pstm.setString(7,dto.getOrderId());

        return pstm.executeUpdate() > 0;
    }


    public boolean deleteOrder(String orderId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM orders WHERE orderId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, orderId);

        return pstm.executeUpdate() > 0;
    }

    public List<OrderDto> getAllOrders() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM orders";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<OrderDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String orderId = resultSet.getString(1);
            String B_id = resultSet.getString(2);
            String pay_id = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String desc = resultSet.getString(5);
            int qty = resultSet.getInt(6);
            String date = resultSet.getString(7);

            var dto = new OrderDto(orderId,B_id,pay_id,price,desc,qty,date);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
