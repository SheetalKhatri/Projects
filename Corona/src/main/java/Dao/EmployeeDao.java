package Dao;

import Dto.EmployeeDto;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public boolean saveEmployee(EmployeeDto employeeDto) throws SQLException {
        Connection connection = JdbcConnection.getDbConnection();
        String query =
                "INSERT INTO employee " +
                        "(fullname, email, password, Address, City, State, zip) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');";

        String fmtQuery = String.format(
                query,
                employeeDto.getFullName(),
                employeeDto.getEmail(),
                employeeDto.getPassword(),
                employeeDto.getAddress(),
                employeeDto.getCity(),
                employeeDto.getState(),
                employeeDto.getZip()
        );

        System.out.println("QUERY:: " + fmtQuery);

        Statement statement = connection.createStatement();
        int row = statement.executeUpdate(fmtQuery);
        return row == 1;
    }

    public List<EmployeeDto> getAllEmployee() throws SQLException {
        Connection connection = JdbcConnection.getDbConnection();
        String query = "select * from employee";
        Statement statement = connection.createStatement();
        List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            EmployeeDto dto = new EmployeeDto();
            dto.setId(rs.getInt("Id"));
            dto.setFullName(rs.getString("FullName"));
            dto.setEmail(rs.getString("Email"));
            dto.setPassword(rs.getString("Password"));
            dto.setAddress(rs.getString("Address"));
            dto.setCity(rs.getString("City"));
            dto.setState(rs.getString("State"));
            dto.setZip(rs.getString("Zip"));
            dtoList.add(dto);
        }
        return dtoList;
    }

    public void delete(int id) throws SQLException {
        Connection connection = JdbcConnection.getDbConnection();
        String query = "delete from employee where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement.toString());
        preparedStatement.execute();
    }

    public EmployeeDto getRecordById(int id) {
        EmployeeDto dto = null;
        try {
            Connection connection = JdbcConnection.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                dto = new EmployeeDto();
                dto.setId(rs.getInt("Id"));
                dto.setFullName(rs.getString("FullName"));
                dto.setEmail(rs.getString("Email"));
                dto.setPassword(rs.getString("Password"));
                dto.setAddress(rs.getString("Address"));
                dto.setCity(rs.getString("City"));
                dto.setState(rs.getString("State"));
                dto.setZip(rs.getString("Zip"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dto;

    }

    public void edit(int id, EmployeeDto newEmployeeDetails) throws SQLException {
        Connection connection = JdbcConnection.getDbConnection();
        String query = "UPDATE employee " +
                "SET fullname=?, email=?, password=?, Address=?, City=?, State=?, zip =? " +
                "where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newEmployeeDetails.getFullName());
        preparedStatement.setString(2, newEmployeeDetails.getEmail());
        preparedStatement.setString(3, newEmployeeDetails.getPassword());
        preparedStatement.setString(4, newEmployeeDetails.getAddress());
        preparedStatement.setString(5, newEmployeeDetails.getCity());
        preparedStatement.setString(6, newEmployeeDetails.getState());
        preparedStatement.setString(7, newEmployeeDetails.getZip());
        preparedStatement.setInt(8, id);
        System.out.println(preparedStatement.toString());
        preparedStatement.executeUpdate();
    }

}
