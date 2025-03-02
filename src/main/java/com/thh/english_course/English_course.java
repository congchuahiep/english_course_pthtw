/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.thh.english_course;

import com.thh.pojo.Question;
import com.thh.pojo.Choice;
import com.thh.service.ChoiceService;
import com.thh.service.JdbcUtils;
import com.thh.service.QuestionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class English_course {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        List<Question> ql = QuestionService.getQuestion(3);
        ql.forEach(q -> {
            System.out.println(q);
            try {
                List<Choice> choices = ChoiceService.getChoices(q.getId());
                for (int i = 0; i < choices.size(); i++) 
                    System.out.printf("%d/ %s\n", i + 1, choices.get(i));
                    
                System.out.print("Your choice: ");
                int idx = sc.nextByte();

                if (choices.get(idx - 1).isIsCorrect() == true) {
                    System.out.println("EXCACTLY!!!! \n");
                } else {
                    System.out.println("WRONGGGGG!!!! \n");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(English_course.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
