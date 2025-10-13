package DBController;
import Model.DTO.employeeInfo;
import db_Connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBEmployeeController {
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
            return resolved>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public employeeInfo searchEmployee(String id) throws SQLException {
        Connection connection=DBConnection.getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM employee_details WHERE id=?");
        stm.setObject(1,id);
        ResultSet employee=stm.executeQuery();
        while(employee.next()){
            String eId=employee.getString("id");
            String eName=employee.getString("name");
            String eEmail=employee.getString("email");
            String ePhone=employee.getString("phone");
            String eDepartment=employee.getString("department");
            String eRole=employee.getString("role");
            return (new employeeInfo(eId,eName,eEmail,ePhone,eDepartment,eRole));
        }
        return null;
    }
    public boolean deleteStudent(int code) throws SQLException {
        Connection connection=DBConnection.getConnection();
        PreparedStatement stm=connection.prepareStatement("DELETE FROM employee_details WHERE id=?");
            stm.setObject(1,code);
        int resolved= 0;
            resolved = stm.executeUpdate();
        boolean b = resolved > 0;
        return b;
    }
    public ArrayList<employeeInfo> getAllEmployees() throws SQLException {
        ArrayList<employeeInfo> employeeArray=new ArrayList<>();
        Connection connection=DBConnection.getConnection();
        PreparedStatement stm= null;
            stm = connection.prepareStatement("SELECT * FROM employee_details");
            ResultSet employees= null;
            employees = stm.executeQuery();
        while (employees.next()){
            String id=employees.getString("id");
            String name=employees.getString("name");
            String email=employees.getString("email");
            String phoneNo=employees.getString("phone");
            String department=employees.getString("department");
            String role=employees.getString("role");
            employeeArray.add(new employeeInfo(id,name,email,phoneNo,department,role));
        }
        return employeeArray;
    }

}
