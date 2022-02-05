import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> players = new ArrayList<>();
        ArrayList<Player> playersList = new ArrayList<>(); 

        loadPlayerFile(players);
        for (int i = 0; i < players.size(); i++) {
            Player player = new Player(players.get(i));
            playersList.add(player);
            System.out.println(playersList.get(i).getName());
        }
    }
        
        
        
    public static /*List<String>*/ void loadPlayerFile(ArrayList<String>players) {
        File file = new File("res/players.txt");
        
        
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line != null)
            {
                
                String[] lineContent = line.split(",");
                System.out.println(line);
                line = bufferedReader.readLine();
                players.add(lineContent[0]);
                
                
            }
            System.out.println("________________________");
            bufferedReader.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
        // return players;
            
    }
        

}
