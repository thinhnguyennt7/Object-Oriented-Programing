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
        // contactName = Optional.of(contactName);
        this.contactName = contactName;
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
        this.isImportant = isImportant;
    }

   /**
    * Getter method for the contact
    */
    public Optional<String> getContact() {
        return contactName;
    }

    /**
    * Getter method for the to the person want to send message to
    */
    public String getTo() {
        return to;
    }

    /**
    * Getter method for the from a person want to send the message
    */
    public String getFrom() {
        return from;
    }

    /**
    * Getter method for the body message
    */
    public String getBody() {
        return body;
    }

    /**
    * Getter method for the local date time
    */
    public LocalDateTime getDate() {
        return date;
    }

    /**
    * Getter method for the isImportant
    */
    public boolean getIsImportant() {
        return isImportant;
    }

    public String toString() {
        return "***Contact: " + contactName + ", To: " + to + ", From: " + from + ", Body: " + body + ", Date: " + date + ", isImportant: " + isImportant + "****";
    }

}