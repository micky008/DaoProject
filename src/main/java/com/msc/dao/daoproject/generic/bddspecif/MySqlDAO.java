/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msc.dao.daoproject.generic.bddspecif;

import com.msc.dao.daoproject.generic.GenericDao;
import com.msc.dao.daoproject.generic.GenericDaoImpl;
import com.msc.dao.daoproject.generic.GenericInterfaceDao;
import java.sql.SQLException;

/**
 *
 * @author micky
 */
public class MySqlDAO<T> implements GenericInterfaceDao<T>{

    private GenericDaoImpl<T> gen;
    
    public MySqlDAO(GenericDao<T> genericDAO){
        gen = (GenericDaoImpl<T>) genericDAO;
    }
    
    
    /**
     * Retourne le dernier objet inseré.
     *
     * @return
     * @throws SQLException
     */
    public T getLastInsert() throws SQLException {
        String where = "where id = LAST_INSERT_ID()";
        return gen.preparedSelectOnce(where, null);
    }

    /**
     * Retourne le SQL pour une date.
     *
     * @param date la date a formatter
     * @param pattern le pattern de la date
     * @return TO_DATE('xx/yy/zzzz','dd/mm/yyyy');
     */
    public String toDate(String date) {
        return " CONVERT('" + date + "', DATE) ";
    }

}