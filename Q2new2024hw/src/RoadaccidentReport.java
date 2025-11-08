import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RoadaccidentReport extends Roadaccident{
    public RoadaccidentReport(String vehicletype, String city, int numberofaccidents) {
        super(vehicletype, city, numberofaccidents);
    }
    public String accidentprintReport(){
        System.out.println("accident Total");
        System.out.println(" ");
        System.out.println("tpe of vechile : "+getVehicletype());
        System.out.println("city of accident : "+getCity());
        System.out.println("number of accident : "+getNumberofaccidents());
        return getVehicletype()+getCity()+getNumberofaccidents();
    }

    String fileName ="user_input.txt";

    public void savetothefile(){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write("accident Total\n"+"\n"+
                    "tpe of vechile: "+getVehicletype()+"\n"+
                    "city of acciden: "+getCity()+"\n"+"number of accident: "+getNumberofaccidents()+"\n");
        } catch (Exception e) {
            System.out.println("Error writing to file:" + e.getMessage());
        }
    }
    public void readfromfile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("RoadAccident_txt"))){
            String read;
            while ((read=reader.readLine())!=null){
                System.out.println(read);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file:" + e.getMessage());
        }
    }


}
