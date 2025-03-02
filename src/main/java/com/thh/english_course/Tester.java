/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thh.english_course;

import com.thh.service.StatsServices;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Tester {
    public static void main(String[] args) throws SQLException {
        StatsServices s = new StatsServices();
        s.countQuestionsByCate("e").forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));
        
        int c1 = s.countQuestionNotEnoughChoice();
        int c2 = s.countEmptyQuestionChoiceContent();
        
        System.out.printf("cau hoi khong co du 4 dap an: %d\n", c1);
        System.out.printf("cau hoi co truong lua chon content rong: %d\n", c2);
    }
}
