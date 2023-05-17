package Lesson38;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    private String name;
    private int id;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //The method saves the student in DB.
    public void save() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Студент збережений в базі даних.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //The method gets information on the student from our DB.
    public static Student getById(int studentId) {
        Student student = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}
