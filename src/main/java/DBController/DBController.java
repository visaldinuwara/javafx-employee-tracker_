package DBController;
import Model.DTO.employeeInfo;
import db_Connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController {
    public boolean addEmployee(employeeInfo employee){
        Connection connection= DBConnection.getConnection();
        PreparedStatement stm= null;
        try {
            stm = connection.prepareStatement("INSERT INTO employee_details VALUES (?,?,?,?,?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stm.setObject(1,employee.getId());
            stm.setObject(2,employee.getName());
            stm.setObject(3,employee.getEmail());
            stm.setObject(4,employee.getPhoneNo());
            stm.setObject(5,employee.getDepartment());
            stm.setObject(6,employee.getRole());
            int resolved=stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return resolved>0;
    }
    public boolean updateEmployee(employeeInfo employee){
        int resolved= 0;
        try {
            Connection connection=DBConnection.getConnection();
            PreparedStatement stm=connection.prepareStatement("UPDATE employee_details SET name=?,email=?,phone=?,department=?,role=? WHERE id=?");
            stm.setObject(1,employee.getName());
            stm.setObject(2,employee.getEmail());
            stm.setObject(3,employee.getPhoneNo());
            stm.setObject(4,employee.getDepartment());
            stm.setObject(5,employee.getRole());
            stm.setObject(6,employee.getId());
            resolved = stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resolved>0;
    }
    public employeeInfo searchEmployee(String id){
        Connection connection=DBConnection.getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM employee_details WHERE id=?");
        stm.setObject(1,id);
        ResultSet employee=stm.executeQuery();
        String id=employee.getNString("id");
        String name=employee.getString();
        String email=employee.getString();
    }
}
