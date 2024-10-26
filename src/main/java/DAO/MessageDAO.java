package DAO;

import Model.Message;
import Util.ConnectionUtil;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
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
    public List<Message> getAllMessages() {
        Connection connection = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "select * from message;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message message = new Message(rs.getInt("message_id"), 
                rs.getInt("posted_by"), 
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch"));
                messages.add(message);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return messages;
    }
    // Retrieve message by ID
    public Message getMessageByID(int message_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "select * from message where message_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, message_id);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Message message = new Message(rs.getInt(message_id),
                rs.getInt("posted_by"), 
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch"));
                return message;
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Message();
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
