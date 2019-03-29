package cs401.LoginAndDataBase.Database;

public class User {
    int id_;
    String username_;
    String password_;
    /*CONSTRUCTORS*/
    public User(){}

    public User(int id, String username, String password){
        this.id_ = id;
        this.username_ = username;
        this.password_ = password;
    }

    public User(String username, String password)
    {
        this.username_= username;
        this.password_ = password;
    }
    /*SETTERS AND GETTERS*/
    public int getId()
    {
        return this.id_;
    }

    public void setId(int id) {
        this.id_ = id;
    }

    public void setUsername(String username){
        this.username_= username;
    }

    public String getUsername(){
        return this.username_;
    }

    public void setPassword(String password){
        this.password_ = password;
    }

    public String getPassword(){
        return this.password_;
    }
}
