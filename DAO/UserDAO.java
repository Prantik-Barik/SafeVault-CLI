package DAO;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean isExists(String email) throws SQLException{
        Connection connection = MyConnection.getConnection();
        String str = "select email from users";
        PreparedStatement ps = connection.prepareStatement(str);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            String s = rs.getString(1);
            if(s.equals(email)) {
                return true;
            }
        }

        return false;
    }

    public static int saveUser(User user) throws SQLException{
        Connection connection = MyConnection.getConnection();
        String str = "insert into users values(default,?,?)";
        PreparedStatement ps = connection.prepareStatement(str);
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());

        return ps.executeUpdate();
    }
}
