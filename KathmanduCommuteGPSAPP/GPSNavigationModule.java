package KathmanduCommuteGPSAPP;
public class GPSNavigationModule implements NavigationService
{
    @Override
    public void navigate(String startPoint , String endPoint, RouteValidator ktv) throws NavigationFailedException
        {
          System.out.println("Attempting to navigate from " + startPoint + " to " + endPoint + "....");
          if(startPoint.equalsIgnoreCase("Kalanki"))
          {
            throw new NavigationFailedException("GPS signal lost near Kalanki! Welcome to Kathmandu traffic!");
          }
          try{
            ktv.isValidCommuteRoute(startPoint, endPoint, simulatedDistance(startPoint, endPoint));
            System.out.println("Navigation successful! Estimated Time: 20 minutes (or 2 hours depending on traffic");
           }
           catch(SameLocationException e)
           {
            throw new NavigationFailedException("Route Validation Failed! " + e);
           }
           catch(InvalidRouteException e)
           {
            throw new NavigationFailedException("Route Validation Failed! " + e);
           }
         private double simulatedDistance(String start , String end)
           {
            return 5.0;
           }
        }       
    public static void main(String[] args) 
    {
        RouteValidator ktv = new KathmanduTrafficValidator();
        GPSNavigationModule gps = new GPSNavigationModule();
        try
        {
            gps.navigate("Baneshwor", "Baneshwor", ktv);
            gps.navigate("Budhanilkantha", "Chakrapath", ktv);
            gps.navigate("Thankot", "Swaymbhu", ktv);
        }
        catch(NavigationFailedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
