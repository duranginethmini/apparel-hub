package lk.ijse.apparelHub.model;

import lk.ijse.apparelHub.db.DbConnection;
import lk.ijse.apparelHub.dto.CustomerDto;
import lk.ijse.apparelHub.dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentModel {
    public static List<PaymentDto> loadAllPayments() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Payment";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<PaymentDto> payList = new ArrayList<>();

        while (resultSet.next()) {
            payList.add(new PaymentDto(
                    resultSet.getString(1),
                    resultSet.getDouble(2),
                    resultSet.getString(3)
            ));
        }
        return payList;
    }

    public boolean savePayment(PaymentDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Payment VALUES(?, ?, ?)";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(1, dto.getPay_id());
        pstm.setString(2, String.valueOf(dto.getAmount()));
        pstm.setString(3,dto.getStatus());


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public boolean updatePayment(PaymentDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Payment SET amount = ?, status = ? WHERE Pay_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getPay_id());
        pstm.setString(2, String.valueOf(dto.getAmount()));
        pstm.setString(4, dto.getStatus());

        return pstm.executeUpdate() > 0;
    }

    public boolean deletePayment(String Pay_id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Payment WHERE Pay_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,Pay_id);

        return pstm.executeUpdate() > 0;
    }
}
