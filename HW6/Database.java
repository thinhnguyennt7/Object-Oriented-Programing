import java.ulti.function.Predicate;
import java.ulti.List;
import java.ulti.Map;

/**
* A database of past Messages that have been sent
*@author Tnguyen452
*@version 1.0
*/
public class Database {
    
    private List<Message> messages;

    /**
    *
    * Constructor for the Data base function take in a parameter
    * @param messages Take in the main messages
    *
    */
    public Database(List<Message> messages) {
        messages = this.messages;
    }

    public Message getMessage(int n) {
        return n;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Message> filter(Predicate<Message> filter) {
        return 
    }

    public List<Message> getMessagesBetween(LocalDateTime start,
        LocalDateTime end) {

    }

    public Map<String, List<Message>> sortMessagesByContact() {

    }

    public List<Message> getMessagesWithKeyword(String keyword) {

    }

    public List<Message> getMessagesWithPriority() {

    }
}