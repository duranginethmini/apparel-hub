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

public class CustomerModel {
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO buyer VALUES(?, ?, ?, ?)";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3,dto.getAddress());
        pstm.setString(4, String.valueOf(dto.getTelNum()));

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE buyer SET name = ?, address = ?, telNum = ? WHERE B_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, String.valueOf(dto.getTelNum()));
        pstm.setString(4, dto.getId());

        return pstm.executeUpdate() > 0;
    }

    public boolean deleteCustomer(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM buyer WHERE B_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }
    public static List<CustomerDto> loadAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM buyer";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<CustomerDto> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
            ));
        }
        return cusList;
    }


    public List<CustomerDto> getAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM buyer";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<CustomerDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            int cus_tel = Integer.parseInt(resultSet.getString(4));

            var dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
