package Service;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Message;
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

    // Retrieve message by ID

    // Delete message by ID

    // Update message by ID

    // Retrieve messages by user
}
