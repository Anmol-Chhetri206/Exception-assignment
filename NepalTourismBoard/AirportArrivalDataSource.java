package NepalTourismBoard;
import java.util.ArrayList;
import java.util.List;
public class AirportArrivalDataSource extends TouristDataSource
{
    public AirportArrivalDataSource()
    {
        super("Tribhuvan Airport Arrivals");
    }
    public List<String> fetchData() throws DataSourceAccessException
    {
      if(sourceName.startsWith("Tribhuvan") && Math.random()<0.3)
      {
         throw new ConnectionLostException("Airport data connection lost! Maybe a pigeon sat on the antenna?");
      }
      else{
       List<String> data = new ArrayList<>();
        data.add("Airport: Tribhuvan International");
        data.add("Visitor: Anmol, Nepal");
        data.add("Visitor: Emily White, UK");
        return data;
      }
    }
    public static void main(String[] args)
    {
        AirportArrivalDataSource ds = new AirportArrivalDataSource();
       
        try{
            List<String> data = ds.fetchData();
            for(String d : data)
            {
                System.out.println(d);
            }
        }
        catch(DataSourceAccessException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}
class ConnectionLostException extends DataSourceAccessException
{
    public ConnectionLostException(String message)
    {
        super(message);
    }
}
