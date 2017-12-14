import static org.junit.Assert.*;
import org.junit.*;

public class PlayersTests {
    Player player1;
    Player player2;

    @Before
    public void createPlayers(){
        player1=new Player("Player1Name");
        player2=new Player("Player2Name");
    }

    @Test
    public void testName(){
        assertEquals("Player1Name", player1.getName());
        assertEquals("Player2Name", player2.getName());
    }

}
