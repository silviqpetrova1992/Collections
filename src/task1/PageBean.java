package task1;

import java.util.List;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 3/27/15.
 */
public class PageBean {
  private int pageSize;
  private int index = 0;
  private List<Object> list;

  /**
   * the constructor with  parameters
   *
   * @param size This is the size of  the page.
   * @param list This is the exact list.
   */
  public PageBean(int size, List<Object> list) {
    this.pageSize = size;
    this.list = list;
  }

  /**
   * If there is a next page or not.
   *
   * @return true:If there is or false: If there is not such page.
   */
  public boolean hasNext() {
    return (index > list.size() - 1) ? false : true;
  }

  /**
   * If there is a previous page
   *
   * @return true:If thre is or false:If there is not such page.
   */
  public boolean hasPrevious() {
    return (index == pageSize) ? false : true;
  }

  /**
   * Returns the first page.
   */
  public List<Object> firstPage() {
    index = 0;
    List subList = list.subList(index, index + pageSize);
    index += pageSize;
    return subList;
  }

  /**
   * Returns the last page.
   */
  public List<Object> lastPage() {
    index = ((list.size() / pageSize) * pageSize);
    if(index==list.size()){
      index-=pageSize;
    }
    List subList = list.subList(index, list.size());
    index += pageSize;
    return subList;
  }

  /**
   * Gets the page current number
   *
   * @return The number
   */
  public int getCurrentPageNumber() {
    return index / pageSize;
  }

  /**
   * Returns the next page.
   */
  public List<Object> next() {
    if (index + pageSize >= list.size()) {
      return lastPage();
    }
    List subList = list.subList(index, index + pageSize);
    index += pageSize;

    return subList;
  }

  /**
   * Returns the previous page.
   */
  public List<Object> previous() {
    if (index <= pageSize) {
      return firstPage();
    }
    List subList = list.subList(index - 2 * pageSize, index - pageSize);
    index -= pageSize;

    return subList;

  }
/*
  private String print() {
    StringBuilder a=new StringBuilder();
    for (int i = index; i < (index + pageSize); i++) {
      if (i < list.size()) {
        a.append(list.get(i)).append("\n");
      }
    }
    index = index + pageSize;
    return a.toString();
  }*/
}
