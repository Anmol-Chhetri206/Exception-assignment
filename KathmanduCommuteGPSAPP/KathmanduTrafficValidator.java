package KathmanduCommuteGPSAPP;
public class KathmanduTrafficValidator implements RouteValidator
{
    @Override
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm) throws InvalidRouteException
    {
       if(origin.equalsIgnoreCase(destination))
       {
        throw new SameLocationException("Origin and destination cannot be the same! Are you just spinning in circles, Anmol?");
       }
       if(distanceKm < 0.1 || distanceKm > 30)
       {
        throw new InvalidRouteException("Distance " + distanceKm + "km is unrealistic for Kathmandu Commute!...");
       }
       return true;
    }
    public static void main(String[] args) 
    {
        KathmanduTrafficValidator ktv = new KathmanduTrafficValidator();
        try
        {
            ktv.isValidCommuteRoute("Thankot", "Thankot", 0.1);
         ktv.isValidCommuteRoute("Gwarko", "Budhanilkantha", 20);
         ktv.isValidCommuteRoute("Sanepa", "Baneshwar", 30);
           System.out.println("Testing...");
        }
        catch(SameLocationException e)
        {
            System.out.println(e.getMessage());
        }
        catch(InvalidRouteException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
class SameLocationException extends InvalidRouteException
{
    public SameLocationException(String message)
    {
        super(message);
    }
}

