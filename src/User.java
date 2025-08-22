public class User extends Person {
    private String userName;
    private String password;
    public User(int id,String firstName, String lastName,int age,String userName, String password){
        super(id,firstName,lastName,age);
        this.userName=userName;
        this.password=password;
    }
    public String getUserName()
    {
        return userName;
    }

    public String getPassword(){
        return password;
    }


}
