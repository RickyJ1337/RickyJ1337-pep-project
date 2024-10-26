package Service;

import DAO.MessageDAO;
import Model.Message;

import java.util.List;
public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }
    // Method here to create new message
    public Message postMessage(Message message) {
        return messageDAO.postMessage(message);
    }
    // Method here to retrieve messages
    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }
    // Retrieve message by ID
    public Message getMessageByID(int message_id) {
        return messageDAO.getMessageByID(message_id);
    }
    // Delete message by ID
    public Message deleteMessageByID(int message_id) {
        return messageDAO.deleteMessageByID(message_id);
    }
    // Update message by ID
    public Message updateMessageText(int message_id, String message_text) {
        return messageDAO.updateMessageText(message_id, message_text);
    }
    // Retrieve messages by user
    public List<Message> getMessagesByUser(int account_id) {
        return messageDAO.getMessagesByUser(account_id);
    }
}
