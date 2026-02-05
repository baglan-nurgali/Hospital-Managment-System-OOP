package model.database;

import model.model.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void insertDoctor(Doctor doctor){
        String sql = "INSERT INTO doctor (name, age, specialization) VALUES (?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, doctor.getName()) ;
            statement.setInt(2,doctor.getAge()) ;
            statement.setString(3,doctor.getSpecialization());
            statement.executeUpdate();
            System.out.println("Doctor added to DB!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getAllDoctors() {
        String sql = "SELECT * FROM";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
                System.out.println("ID "+resultSet.getInt("doctorid")+
                "|Name: " + resultSet.getString("name")+
                "|Age "  +resultSet.getInt("age")+
                "|Specialization " + resultSet.getString("specialization"));}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor getDoctorById(int id){
        String sql = "SELECT * FROM doctor WHERE doctorid = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
                 statement.setInt(1, id);
                 try(ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        return new Doctor(resultSet.getInt("doctorid"), resultSet.getString("name"),
                                resultSet.getInt("age"), resultSet.getString("specialization"));
                    }

                    }
                 }
           catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctor SET name = ?, age = ?, specialization = ? WHERE doctorid = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getName());
            statement.setInt(2, doctor.getAge());
            statement.setString(3, doctor.getSpecialization());
            statement.setInt(4, doctor.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDoctor(int id) {
        String sql = "DELETE * FROM doctor WHERE doctorid = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Doctor> searchByName(String name) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctor WHERE name ILIKE ? ORDER BY name";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + name + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Doctor(resultSet.getInt("doctorid"), resultSet.getString("name"),
                            resultSet.getInt("age"), resultSet.getString("specialization")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Doctor> searchByAgeRange(int min, int max) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctor WHERE age BETWEEN ? AND ? ORDER BY age";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, min);
            statement.setInt(2, max);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Doctor(resultSet.getInt("doctorid"), resultSet.getString("name"),
                        resultSet.getInt("age"), resultSet.getString("specialization")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

   public void deleteAllDoctors() {
        String sql = "DELETE FROM doctor";
       try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.executeUpdate();
           System.out.println("All records deleted!");
           }catch (SQLException e){
           e.printStackTrace();
       }
   }



}