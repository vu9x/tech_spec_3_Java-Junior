package org.example.task1;

import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4001/";
        String user = "root";
        String password = "pass";

        // Подключение к базе данных
        Connection connection = DriverManager.getConnection(url, user, password);

        // Создание базы данных
        createDatabase(connection);
        System.out.println("Database created successfully");

        // Использование базы данных
        useDatabase(connection);
        System.out.println("Use database successfully");

        // Создание таблицы
        createTable(connection);
        System.out.println("Use database successfully");

        // Вставка данных
        Random random = new Random();
        int count = random.nextInt(5, 11);
        for (int i = 0; i < count; i++) {
            insertData(connection, Student.create());
        }
        System.out.println("Insert data successfully");

        //Чтение данных
        Collection<Student> students = readData(connection);
        for (var student: students){
            System.out.println(student);
        }
        System.out.println("Read data successfully");

        // Обновление данных
        for(var student: students){
            student.updateName();
            student.updateAge();
            updateData(connection, student);
        }
        System.out.println("Update data successfully");

        // Удаление данных
        for (var student: students){
            deleteData(connection, student.getId());
        }
        System.out.println("Delete data successfully");

        // Закрытие соединения
        connection.close();
        System.out.println("Database connection close successfully");
    }

    private static void createDatabase(Connection connection) throws SQLException{
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS studentsDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)){
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException{
        String useDatabase = "USE studentsDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabase)){
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }

    /**
     *
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void insertData(Connection connection, Student student) throws SQLException{
        String insertDataSQL = "INSERT INTO students (name, age) VALUES(?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)){
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        }
    }

    /**
     * Чтение данных из таблицы students
     * @param connection Соединение с БД
     * @return коллекция студентов
     * @throws SQLException Исключение при выполнении запроса
     */
    private static Collection<Student> readData(Connection connection) throws SQLException{
        ArrayList<Student> studentsList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM students;";
        try(PreparedStatement statement = connection.prepareStatement(readDataSQL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                studentsList.add(new Student(id, name, age));
            }
            return studentsList;
        }
    }

    /**
     * Обновление данных в таблице students по идентификатору
     * @param connection соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void updateData(Connection connection, Student student) throws SQLException{
        String updateDataSQL = "UPDATE students SET name=?, age=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)){
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }
    }

    private static void deleteData(Connection connection, int id) throws SQLException{
        String deleteDataSQL = "DELETE FROM students WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)){
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
