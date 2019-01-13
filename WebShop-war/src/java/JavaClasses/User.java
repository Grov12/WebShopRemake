package JavaClasses;

public class User {
    
    String username;
    int points;
    
    public User(String username, int points){
        this.username = username;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }
    
    public void addPoints(int p){
        this.points += p;
    }
    
}
