/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.thh.english_course;

import com.thh.pojo.Question;
import com.thh.service.JdbcUtils;
import com.thh.service.QuestionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class English_course {

    public static void main(String[] args) throws SQLException {
        List<Question> ql = QuestionService.getQuestion(3);
        ql.forEach(q -> System.out.println(q));
    }
}
