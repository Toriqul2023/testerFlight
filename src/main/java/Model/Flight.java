package Model;

public class Flight extends CommonInFlight_User{

    private String from;
    private String to;
    private String date;
    private String time;

   public  Flight(int id,String name,String from,String to,String date,String time){
      super(name,id);
       this.from=from;
       this.to=to;
       this.date=date;
       this.time=time;

   }

    public String getTo(){
        return this.to;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    public int getId(){
       return this.id;
    }



}
