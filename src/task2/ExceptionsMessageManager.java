package task2;

import java.util.Hashtable;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 3/31/15.
 */
public class ExceptionsMessageManager {
  private Hashtable<String, String> exceptions;
  private StringBuilder mess;

  /**
   * This is a constructor
   */
  public ExceptionsMessageManager() {
    this.exceptions = new Hashtable<String, String>();
    this.mess = new StringBuilder();
    exceptions.put("18000", "Wrong name");
    exceptions.put("18400", "Incorrect input parameter");
    exceptions.put("18300", "Incorrect number");
    exceptions.put("18200", "Incorrect price");
    exceptions.put("18100", "Wrong city");
  }

  /**
   * Register an error message in the HashTable
   *
   * @param messageCode This is the code of the exception.
   * @param message     This is the message of the exception.
   */
  public void registerErrorMessage(String messageCode, String message) {
    if (!exceptions.containsValue(message) && !exceptions.containsKey(messageCode)) {
      exceptions.put(messageCode, message);
      return;
    }
    if (exceptions.containsKey(messageCode)) {
      throw new ProgrammerMistakeException("Exception with this code: '" + messageCode + "' already exist!");
    } else {
      throw new ProgrammerMistakeException("Exception with this message: '" + message + "' already exist!");
    }
  }

  /**
   * Apply the exception with code="messageCode" to the message.
   *
   * @param messageCode The code of the exception.
   */
  public void raiseError(String messageCode) {
    if (exceptions.containsKey(messageCode)) {
      mess.append(exceptions.get(messageCode)).append("\n");
      return;
    }
    throw new ProgrammerMistakeException("Exception with this code" + messageCode + " doesn't exist!");
  }

  /**
   * Returns the message with all errors/exceptions that we apply with "raiseError" method.
   *
   * @throws Exception
   */
  public void throwErrors() throws Exception {
    if (mess.length() != 0) {
      throw new Exception(mess.toString());
    }
  }
}
