package lk.ijse.apparelHub.model;

import lk.ijse.apparelHub.db.DbConnection;
import lk.ijse.apparelHub.dto.StockDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockModel {

    public boolean saveStock(StockDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Stock VALUES(?, ?, ?, ?)";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(1, dto.getStockId());
        pstm.setString(2,dto.getType());
        pstm.setString(3, String.valueOf(dto.getAmount()));
        pstm.setString(4, dto.getDescription());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public boolean updateStock(StockDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Stock SET Type = ?, Description = ?,  WHERE St_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getStockId());
        pstm.setString(2, dto.getType());
        pstm.setString(3, String.valueOf(dto.getAmount()));
        pstm.setString(4, dto.getDescription());

        return pstm.executeUpdate() > 0;
    }

    public boolean deleteCustomer(String stockId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Stock WHERE St_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,stockId);

        return pstm.executeUpdate() > 0;
    }
}
