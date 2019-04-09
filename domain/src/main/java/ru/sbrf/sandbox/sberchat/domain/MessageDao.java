package ru.sbrf.sandbox.sberchat.domain;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MessageDao {

    public Collection<Message> getMessages() {
        List<Message> result = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()
        ){
            ResultSet rs = statement.executeQuery(
                    "select * from Message order by id asc");
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setName(rs.getString("name"));
                message.setText(rs.getString("text"));
                result.add(message);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void saveMessage(Message message) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "insert into Message (name, text) values (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, message.getName());
            statement.setString(2, message.getText());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    void init() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()
        ){
            statement.execute("create table Message (\n" +
                    "       id integer not null AUTO_INCREMENT,\n" +
                    "        name varchar(255),\n" +
                    "        text varchar(255),\n" +
                    "        primary key (id)\n" +
                    "    )");
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private String CONNECTION_STRING = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    private String USER = "sa";
    private String PWD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USER, PWD);
    }
}
