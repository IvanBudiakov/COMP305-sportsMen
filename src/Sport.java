import java.util.ArrayList;

public class Sport {
    String name;
    ArrayList<String> playerList;

    public Sport(String name)
    {
        this.name = name;
        playerList = new ArrayList<>();
    }

    public void addPlayer(String name)
    {
        playerList.add(name);
    }

    public String getName() {return name;}
    public ArrayList<String> getPlayerList() {return playerList;}
}
