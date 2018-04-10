import java.time.LocalDateTime;
import java.util.function.Predicate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
* A database of past Messages that have been sent
*@author Tnguyen452
*@version 1.0
*/
public class Database {
    private List<Message> messages;
    /**
    * Constructor for the Data base function take in a parameter
    * @param messages Take in the main messages
    *
    */
    public Database(List<Message> messages) {
        this.messages = new ArrayList<>(messages);
    }

    /**
    * The getMessage function to return the message at the specific index
    * @param index Take in the index of the messages want to return
    * @return Message Return the message at the index
    */
    public Message getMessage(int index) {
        return messages.get(index);
    }

    /**
    * The getMessage function to return the message at the specific index
    * @return List Return all the messages in the list
    */
    public List<Message> getMessages() {
        return messages;
    }

    /**
    * The filter function that return the list of message filted by Predicate
    * @param filter Take in the predicate of the message
    * @return List Return all the messages in the list after filted
    */
    public List<Message> filter(Predicate<Message> filter) {
        List<Message> output = new ArrayList<>();
        for (Message each : messages) {
            if (filter.test(each)) {
                output.add(each);
            }
        }
        return output;
    }

    /**
    * The filter function that return the list of message filted by Predicate
    * @param start Take in the starting time of the message
    * @param end Take in the ending time of the message
    * @return List Return all the messages in the list after filted
    */
    public List<Message> getMessagesBetween(LocalDateTime start,
        LocalDateTime end) {
        return filter(p -> ((p.getDate().compareTo(start) >= 0)
        && (p.getDate().compareTo(end) <= 0)));
    }

    /**
    * The sortMessagesByContact function that return the list of message sort
    * by contact
    * @return Map Return all the messages in the list after filted
    */
    public Map<String, List<Message>> sortMessagesByContact() {
        Map<String, List<Message>> hashmap = new HashMap<String,
            List<Message>>();
        List<Message> allmess;
        for (Message each : messages) {
            boolean checkKeyPresent = each.getcontactName().isPresent();
            if (checkKeyPresent) {
                String getKeyWord = each.getcontactName().get();
                if (!hashmap.containsKey(getKeyWord)) {
                    allmess = filter(new Predicate<Message>() {
                        @Override
                        public boolean test(Message p) {
                            boolean currentValue = p.getcontactName()
                                .isPresent();
                            if (currentValue) {
                                return p.getcontactName().get()
                                    .equals(getKeyWord);
                            } else {
                                return false;
                            }
                        }
                    });
                    hashmap.put(getKeyWord, allmess);
                }
            }
        }
        return hashmap;
    }

    /**
    * The getMessagesWithKeyword function that return the list of message
    * filted by Predicate
    * @param keyword Take in the keyword of the message
    * @return List Return all the messages in the list after filted
    */
    public List<Message> getMessagesWithKeyword(String keyword) {
        return filter(new CheckKey(keyword));
    }

    /**
    * This is the private inner class that help getMessageWithKeyword to do
    * there job while looking for the specific string of keyword in the message
    */
    private class CheckKey implements Predicate<Message> {
        private String keyword;
        public CheckKey(String keyword) {
            this.keyword = keyword;
        }
        @Override
        public boolean test(Message m) {
            return m.getBody().toUpperCase().contains(keyword.toUpperCase());
        }
    }

    /**
    * The getMessagesWithPriority function that return the list of message that
    * important
    * @return List Return all the messages in the list after filted is
    * important
    */
    public List<Message> getMessagesWithPriority() {
        return filter(Message::getIsImportant);
    }
}