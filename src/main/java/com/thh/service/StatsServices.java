/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thh.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class StatsServices {
    public List<Object[]> countQuestionsByCate(String kw) throws SQLException {
        List<Object[]> result = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConn()) {
            CallableStatement stm = connection.prepareCall("{ CALL count_questions_by_cate(?) }");
            stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Object[] o = { rs.getInt("id"), rs.getString("name"), rs.getInt("quantity") };
                result.add(o);
            }
        }
        
        return result;
    }
    
    public int countQuestionNotEnoughChoice() throws SQLException {
        int result = 0;
        try (Connection connection = JdbcUtils.getConn()) {
            CallableStatement stm = connection.prepareCall("{ CALL question_not_enough_choice() }");
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            result = rs.getInt("count_questions");
        }
        return result;
    }
    
    public int countEmptyQuestionChoiceContent() throws SQLException {
        int result = 0;
        try (Connection connection = JdbcUtils.getConn()) {
            CallableStatement stm = connection.prepareCall("{ CALL count_empty_question_choice_content() }");
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            result = rs.getInt("count_questions");
        }
        return result;
    }
}
