/**
* OvertrainedAthleteException class that will throw when the
* athlete overtrainedAtleteException
*
* @author Thinh Nguyen
* @version 1.0
*/
public class OvertrainedAthleteException extends Exception {

    /**
    * Constructor that will invoke the Exception constructor
    * @throws OvertrainedAthleteException Throw exception
    * @param message Take in the message to throw
    */
    public OvertrainedAthleteException(String message) {
        super(message);
    }
}