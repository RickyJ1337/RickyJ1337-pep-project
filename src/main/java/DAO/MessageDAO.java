package DAO;

import Model.Message;
import Util.ConnectionUtil;

import java.sql.*;
public class MessageDAO {
    // Method here to create new message and add it to the database
    public Message postMessage(Message message) {
        Connection connection = ConnectionUtil.getConnection();

        int posted_by = message.getPosted_by();
        String message_text = message.getMessage_text();
        Long time_posted_epoch = message.getTime_posted_epoch();

        if (message_text == "") {return null;}
        try {
            String sql = "insert into message (posted_by, message_text, time_posted_epoch) values (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, posted_by);
            preparedStatement.setString(2, message_text);
            preparedStatement.setLong(3, time_posted_epoch);

            preparedStatement.executeUpdate();

            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()) {
                int generated_message_id = (int) pkeyResultSet.getLong(1);
                return new Message(generated_message_id, posted_by, message_text, time_posted_epoch);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    // Method here to retrieve messages
    public Message getAllMessages() {
        return null;
    }
    // Retrieve message by ID
    public Message getMessageByID() {
        return null;
    }
    // Delete message by ID
    public Message deleteMessageByID() {
        return null;
    }
    // Update message by ID
    public Message updateMessageByID() {
        return null;
    }
    // Retrieve messages by user
    public Message getMessagesByUser() {
        return null;
    }
}
