import java.util.Optional;
import java.time.LocalDateTime;

/**
* A representation of a text message
*@author Tnguyen452
*@version 1.0
*/
public class Message {

    private Optional<String> contactName;
    private String to;
    private String from;
    private String body;
    private LocalDateTime date;
    private boolean isImportant;

    /**
    *
    * Constructor for the message function take in several parameters
    *@param contactName Take in the contact name of a person
    *@param to Take in the person we want to send it TO
    *@param from Take in the person we want to send it FROM
    *@param body Take in the body content of the message
    *@param date Take in the local date and time of the message
    *@param isImportant Take in the condition that show if the message is
    * important or not
    *
    */
    public Message(Optional<String> contactName, String to, String from,
        String body, LocalDateTime date, boolean isImportant) {
        this.contactName = contactName;
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
        this.isImportant = isImportant;
    }

   /**
    * Getter method for the contact
    * @return Optional Return the contact name
    */
    public Optional<String> getcontactName() {
        return contactName;
    }

    /**
    * Getter method for the to the person want to send message to
    * @return String Return the to
    */
    public String getTo() {
        return to;
    }

    /**
    * Getter method for the from a person want to send the message
    * @return String Return the from
    */
    public String getFrom() {
        return from;
    }

    /**
    * Getter method for the body message
    * @return String Return the body of the message
    */
    public String getBody() {
        return body;
    }

    /**
    * Getter method for the local date time
    * @return LocalDateTime Return the to date
    */
    public LocalDateTime getDate() {
        return date;
    }

    /**
    * Getter method for the isImportant
    * @return boolean Return if the message is important
    */
    public boolean getIsImportant() {
        return isImportant;
    }
}