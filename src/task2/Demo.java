package task2;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 3/30/15.
 */
public class Demo {
  public static void main(String[] args) {
    ExceptionsMessageManager manager = new ExceptionsMessageManager();
//    try {
//      manager.raiseError("18000");
//      manager.registerErrorMessage("18500", "Wrong ID");
//      manager.raiseError("18500");
//      manager.raiseError("18400");
//      manager.throwErrors();
//    } catch (Exception e) {
//     // e.printStackTrace();
//      System.err.println(e.getMessage());
//    }

    try {
      manager.throwErrors();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

