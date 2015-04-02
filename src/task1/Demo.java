package task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 3/27/15.
 */
public class Demo {
  public static void main(String[] args) throws Exception {
    List<Object> list = new ArrayList<Object>();
    list.add("az");
    list.add("tuk");
    list.add("chak");
    list.add("se");
    list.add("useshtam");
    list.add("si");
    list.add("kok");
    list.add("ujas");
    list.add("ujas1");
    list.add("ujas2");

    PageBean bean = new PageBean(3, list);

    System.out.println("If you want to exit pllease select 2!");
    System.out.println(bean.firstPage().toString());
    Scanner sc = new Scanner(System.in);
    System.out.printf("_____________________________%d_______\n", bean.getCurrentPageNumber());
    String a = sc.next();


    while (!a.equals("2")) {
      System.out.println("____________________________________");
      if (a.equals("next()") && bean.hasNext()) {
        System.out.println(bean.next());
      } else {
        if (a.equals("next()") && !bean.hasNext()) {
          System.out.println(bean.lastPage());
          System.err.println("This is the last page!");
        }
      }
      if (a.equals("previous()") && bean.hasPrevious()) {
        System.out.println(bean.previous());
      } else {
        if (a.equals("previous()") && !bean.hasPrevious()) {
          System.out.println(bean.firstPage());
          System.err.println("This is the first page!");
        }
      }
      if (!a.equals("next()") && !a.equals("previous()") && !a.equals("2")) {
        System.out.println("Uncorrect choice!");
      }
      System.out.printf("_____________________________%d_______\n", bean.getCurrentPageNumber());
      a = sc.next();

    }


  }
}
