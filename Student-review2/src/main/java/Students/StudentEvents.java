package Students;



import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public interface StudentEvents {

    void insertData() throws IOException,  SQLException;

    void insertDBS(Students student) throws SQLException;




    default void displayData() throws SQLException {

    }

    void deleteData() throws SQLException;

    void deleteDB(int regNo) throws SQLException;
}

