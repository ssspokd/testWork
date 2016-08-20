/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author spok
 */
public interface ObjectDB<T>
{
    void insert(T t) throws SQLException;
   
    T executeObject(T t) throws SQLException;
    ArrayList<T> executeList(T t) throws SQLException;    
    T fillObject(T t) throws SQLException;
    T getObjectByID(long id) throws SQLException;
    //T  getAllObjects() throws SQLException;
    ArrayList<T>  getAllObjects() throws SQLException;
    void UpdateObject(T t) throws SQLException;
    void UpdateOrInsertObject(T t) throws SQLException;
    void DeleteObject(T t) throws SQLException;
}
