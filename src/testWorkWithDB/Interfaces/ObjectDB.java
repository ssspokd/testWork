/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author spok
 * @param <T>
 */
public interface ObjectDB<T>
{
    void insert(T t) throws SQLException;    
    T getObjectByID(long id) throws SQLException;
    ArrayList<T>  getAllObjects() throws SQLException;
    void updateObject(T t) throws SQLException;
    void updateOrInsertObject(T t) throws SQLException;
    void deleteObject(T t) throws SQLException;
}
