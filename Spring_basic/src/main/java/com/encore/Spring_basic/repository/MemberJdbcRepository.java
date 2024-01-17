package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJdbcRepository implements MemberRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Member> findAll() {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from member";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Member> members = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String emil = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDateTime creat_at = resultSet.getTimestamp("create_at").toLocalDateTime();
                Member member = new Member(name, emil, password);
                member.setId(id);
//                member.setCreate_at(creat_at);
                members.add(member);
            }
            return members;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Member save(Member member) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "insert into member(name,email,password) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2,member.getEmail());
            preparedStatement.setString(3,member.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Member> findById(long id) {
        Member member = null;
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from member where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int idx = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String emil = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDateTime creat_at = resultSet.getTimestamp("create_at").toLocalDateTime();
                member = new Member(name, emil, password);
                member.setId(idx);
//                member.setCreate_at(creat_at);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  Optional.ofNullable(member);
    }

    @Override
    public void delete(Member member) {

    }

    @Override
    public void deleteById(long id) {

    }

//    @Override
//    public Optional<Member> delete(long id) {
//        return Optional.empty();
//    }
}
