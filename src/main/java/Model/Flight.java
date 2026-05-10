package Model;

public class Flight {
    private int id;
    private String name;
    private String from;
    private String to;
    private String date;
    private String time;

   public  Flight(int id,String name,String from,String to,String date,String time){
       this.id=id;
       this.name=name;
       this.from=from;
       this.to=to;
       this.date=date;
       this.time=time;

   }
   public String getName(){
       return this.name;
   }
    public String getFrom(){
        return this.from;
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
