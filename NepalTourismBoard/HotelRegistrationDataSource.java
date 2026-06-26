package NepalTourismBoard;

import java.util.ArrayList;
import java.util.List;

public class HotelRegistrationDataSource extends TouristDataSource
{
    public HotelRegistrationDataSource()
    {
        super("Kathmandu Hotels Registration");
    }
    @Override
    public List<String> fetchData() throws DataSourceAccessException
    {
       if(sourceName.contains("Hotels") && Math.random()<0.2)
       {
        throw new AuthenticationFailedException("Hotel API authentication failed! Did someone forget the password again?");
       }
       else
       {
        List<String> data = new ArrayList<>();
        data.add("Hotel: Hyatt Regency");
        data.add("Visitor: Anmol, Nepal");
        data.add("Visitor: Emily White, UK");
        return data;
       }
    }
    public static void main(String[] args) {
        HotelRegistrationDataSource hrds = new HotelRegistrationDataSource();
        try
        {
            List<String> data = hrds.fetchData();
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

class AuthenticationFailedException extends DataSourceAccessException
{
    public AuthenticationFailedException(String message)
    {
        super(message);
    }
}
