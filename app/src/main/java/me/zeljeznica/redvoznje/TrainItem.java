package me.zeljeznica.redvoznje;

/**
 * Created by stevyhacker on 16.8.14..
 */
public class TrainItem {

            int id;
            String destination;
            String timeOfDeparture;

    public TrainItem(){

    }

    public TrainItem(int id, String destination, String timeOfDeparture){
        this.id = id;
        this.destination = destination;
        this.timeOfDeparture = timeOfDeparture;
    }

}
