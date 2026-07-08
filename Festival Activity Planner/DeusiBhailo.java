import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DeusiBhailo extends FestivalActivity{
    List<String> plannedRoutes;
    int numberOfPerformers;
    public DeusiBhailo(double cost , List<String> plannedRoutes , int numberOfPerformers)
    {
        super("Deusi Bhailo Program" , cost);
        this.plannedRoutes=plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }
    public static void main(String[] args)
        {
          List<String> r1 = Arrays.asList("Chakrapath","Buspark","Chabel");
          List<String> r2 = new ArrayList<>();
          DeusiBhailo[] events =
          {
            new DeusiBhailo(30000, r2, 5),
            new DeusiBhailo(40000, r1, 9),
            new DeusiBhailo(80000, r1, 3)      
          };
          for(DeusiBhailo db: events)
            {
            try{
            db.displayOverview();
            db.planActivity();
           }
           catch(NoRouteException e)
           {
            System.out.println(e.getMessage());
           }
           catch(FestivalPlanningException e)
           {
            System.out.println(e.getMessage());
           }
          }
      }
    @Override
        public void planActivity() throws FestivalPlanningException
        {
              if(plannedRoutes.isEmpty())
              {
                throw new NoRouteException("No No routes planned for Deusi Bhailo! Are we just singing in the living room?");
              }
              if(numberOfPerformers < 3)
              {
                throw new FestivalPlanningException("Need at least 3 performers for a proper Deusi Bhailo!");
              }
              System.out.println(activityName +" program with " + numberOfPerformers + " performers plamed for " +plannedRoutes.size() + " routes!" );
        };
}
class NoRouteException extends FestivalPlanningException
{
   public NoRouteException(String message)
   {
    super(message);
   }
}
