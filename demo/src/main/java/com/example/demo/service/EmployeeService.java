package com.example.demo.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertEmployee(String name, String email, Integer age){
        String sql = "INSERT INTO users (name,email,age) VALUES (?,?,?)";
        jdbcTemplate.update(sql,name,email,age);
    }

    public List<Map<String,Object>> getAllUsers(){
        String sql = "SELECT * FROM users";
      return  jdbcTemplate.queryForList(sql);
    }

    public Map<String,Object> getUserById(int id){
        String sql = "SELECT * FROM users WHERE ID = ?";
        return jdbcTemplate.queryForMap(sql,id);
    }

    public void updateUsers(int id,String name){
        String sql = "UPDATE users SET name = ? WHERE id = ?";
         jdbcTemplate.update(sql,name,id);
    }

    public void deleteUsers(int id){
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }


    public int addEmployee(String name,String email,int age){
        String sql = "INSERT INTO users (name,email,age) VALUES (:name, :email, :age)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name",name)
                .addValue("email",email)
                .addValue("age",age);
        return namedParameterJdbcTemplate.update(sql,params);
    }




    //@transactional Atomicity(All or nothing)
    @Transactional
    public void createUsersWithOrder(String name,String email,int age ,String product,String user_email){
        String usersql = "INSERT INTO users (name,email,age) VALUES(?,?,?)";
        jdbcTemplate.update(usersql,name,email,age);

        String ordersql ="INSERT INTO orders (user_email,product) VALUES(?,?)";
        jdbcTemplate.update(ordersql,user_email,product);

        if(false){
            throw new RuntimeException("Something went wrong Rolling back");
        }
    }

}