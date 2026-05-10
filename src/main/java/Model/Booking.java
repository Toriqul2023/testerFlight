package Model;

public class Booking {
    private int id;
    private String date;
    private int userId;
    private int flightId;


    public Booking(int id,String date,int userId,int flightid){
        this.id=id;
        this.date=date;
        this.flightId=flightid;
        this.userId=userId;

    }
}
