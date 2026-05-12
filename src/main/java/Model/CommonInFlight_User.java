package Model;

public abstract class CommonInFlight_User {
    protected String name;
    protected int id;
    public CommonInFlight_User(){};
    public CommonInFlight_User(String name,int id){
            this.name = name;
            this.id=id;
    }

    public CommonInFlight_User(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void seId(int id){
        this.id=id;
    }


}
