/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thh.service;

import com.thh.pojo.Choice;
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
public class ChoiceService {

    public static List<Choice> getChoices(String questionId) throws SQLException {
        List<Choice> result = new ArrayList<>();

        try (Connection connection = JdbcUtils.getConn()) {
            PreparedStatement stm = connection.prepareCall("{ CALL get_choices(?) }");
            stm.setString(1, questionId);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getString("id"), rs.getString("content"), rs.getBoolean("is_correct"), rs.getString("question_id"));
                result.add(c);
            }
        }

        return result;
    }
}
