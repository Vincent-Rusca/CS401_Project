package cs401.LoginAndDataBase.Database;

/*This class is used to set and get the users information.
* This will be used to retrieve their data so it can be saved to the database.*/
public class User {
    int id_;
    String username_;
    String password_;

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
