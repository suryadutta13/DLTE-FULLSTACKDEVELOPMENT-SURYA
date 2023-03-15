package Students;



import java.io.IOException;

public interface StudentEvents {

    public void insertData() throws IOException;
    public default void displayData() throws IOException, ClassNotFoundException {

    }

}

