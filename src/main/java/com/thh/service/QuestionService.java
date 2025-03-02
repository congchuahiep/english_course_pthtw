/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thh.service;

import com.thh.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {
    
    public static List<Question> getQuestion(int num) throws SQLException {
        List<Question> result = new ArrayList<>();
        
        try (Connection connection = JdbcUtils.getConn()) {
            PreparedStatement stm = connection.prepareCall("{ CALL get_questions(?) }");
            stm.setInt(1, num);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                result.add(q);
            }
        }
        
        return result;
    }
}
