/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jummartinezro
 */
public class MemberDAO extends AbstractDataBaseDAO {

    public static Member login(Member member) {
        Member m = null;
        Connection connection = connect();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("SELECT * FROM Member WHERE memberEmail= ? AND memberPassword= ?");
            statement.setString(1, member.getMemberEmail());
            statement.setString(2, member.getMemberPassword());
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                m = new Member(result.getInt("memberId"), 
                        result.getString("memberEmail"), 
                        null, 
                        result.getDate("memberJoiningDate"),
                        result.getString("memberName"), 
                        result.getString("memberSurname"), 
                        result.getDate("memberBirthDay"),
                        result.getString("memberNationality"));
            }
            result.close();;
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                closeConnection(connection);
            } catch (SQLException ex) {
                Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return m;
    }

}
