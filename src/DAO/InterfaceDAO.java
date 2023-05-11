package DAO;


public interface InterfaceDAO <T>{

    int add (T t);

    int delete (int id);
    int modify (T t);

   // int selectbById(int id);
     
     
}
