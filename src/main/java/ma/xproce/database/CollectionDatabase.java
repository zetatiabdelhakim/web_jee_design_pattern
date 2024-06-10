package ma.xproce.database;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;

@Getter
@Setter
@Builder
public class CollectionDatabase implements DatabaseFacade {
    String dbUrl;
    String username;
    String password;

    @Override
    public Connection databaseLayer() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("goooooooooood");
        } catch (Exception e) {
            System.out.println("wrong --------" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
