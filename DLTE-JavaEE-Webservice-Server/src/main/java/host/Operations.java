package host;

import oracle.jdbc.driver.OracleDriver;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Operations {
    private Driver driver;
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public Operations(){
        try {
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            System.out.println("Connection towards Oracle is success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @WebMethod
    @WebResult(name="Listofcards")
    public Listofcards fetch(){
        Listofcards cards = new Listofcards();
        try {
            query="select * from cards";
            preparedStatement= connection.prepareStatement(query);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Cards card=new Cards();
                card.setCard_number(resultSet.getInt("card_number"));
                card.setCard_holder(resultSet.getString("Holder_name"));
                card.setCard_pin(resultSet.getInt("PIN"));
                card.setExpiry(resultSet.getString("Expiry"));
                card.setLimit(resultSet.getLong("Card_limit"));
                cards.getCards().add(card);

            }
            //connection.close();
            return cards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}