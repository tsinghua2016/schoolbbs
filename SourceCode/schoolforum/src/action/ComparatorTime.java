package action;

import java.util.Comparator;

import model.ListMsg;

public class ComparatorTime implements Comparator{

 public int compare(Object arg0, Object arg1) {
	 
  ListMsg m0=(ListMsg)arg0;
  ListMsg m1=(ListMsg)arg1;
 if( m0.getIsread()<m1.getIsread()) return -1;
 else if(m0.getIsread()>m1.getIsread()) return 0;
 else return m1.getTime().compareTo(m0.getTime());

  }  
 }