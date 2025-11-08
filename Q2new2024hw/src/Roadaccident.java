public class Roadaccident {
    // vehicle type, city, and number of accidents as parameters
    String vehicletype;
    String city;
    int numberofaccidents;

    public Roadaccident (String vehicletype, String city, int numberofaccidents){
this.vehicletype=vehicletype;
this.city=city;
this.numberofaccidents=numberofaccidents;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public String getCity() {
        return city;
    }

    public int getNumberofaccidents() {
        return numberofaccidents;
    }
}
