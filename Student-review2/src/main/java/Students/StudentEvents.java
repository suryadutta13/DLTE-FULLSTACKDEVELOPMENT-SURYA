package Students;



import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public interface StudentEvents {

    void insertData() throws IOException,  SQLException;

    void insertDB(Students student) throws SQLException;




    default void displayData() throws  ClassNotFoundException, SQLException {

    }

}

