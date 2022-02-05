import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Player> playersList = new ArrayList<>();
        ArrayList<Sport> sportsList = new ArrayList<>();

        loadPlayerFile(sportsList, playersList);
        
        System.out.println("Sport :");
            for (Sport sport : sportsList) {
                
                System.out.println("------------------");
                System.out.println(sport.getName());
                System.out.println("------------------");
                System.out.println("Players:");
                for(String player: sport.getPlayerList())
                {
                    System.out.println('\t' + player);
                }
            }
            System.out.println("------------------");
            System.out.println("All Players :");
            for (Player player : playersList) {
                System.out.println("\t\t" + player.getName());
            }
            System.out.println("*******************");
            
    }

    public static void loadPlayerFile(ArrayList<Sport> sportsList, ArrayList<Player> playersList) {
        File file = new File("res/players.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            ArrayList<String> sports = new ArrayList<>();
            // loop thru all the lines of a given file
            while (line != null) {
                // read and split divide the content
                String[] lineContent = line.split(",");
                // System.out.println(line);
                line = bufferedReader.readLine();
                // _________________________________
                Player player = new Player(lineContent[0].trim());
                playersList.add(player);
                    // loop thru all the sports of the current line 
                for (int i = 1; i < lineContent.length; i++) {
                    if (sports.contains(lineContent[i].trim()))
                        System.out.print("");
                    else
                    {
                        sports.add(lineContent[i].trim());
                        Sport sport = new Sport(lineContent[i].trim());
                        sportsList.add(sport); 
                        sport.addPlayer(lineContent[0].trim());
                    }
                    for(Sport matchingSport : sportsList)
                    {
                        if(lineContent[i].trim().equals(matchingSport.getName()))
                        {
                            matchingSport.addPlayer(lineContent[0]);
                        }
                    }
                }
            }
            bufferedReader.close();
        } 
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
