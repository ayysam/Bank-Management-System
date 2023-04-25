package DAO;

import javax.swing.JTable;

public interface InterfaceDAO <T>{
    int add (T t);
    int delete (int id);
    int modify (T t);
}
