import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DashainFestivalPlanner 
{
   public static void executeFestivalPlan(List<FestivalActivity>activities)
   {
      for(FestivalActivity activity: activities)
      {
        System.out.println();
        System.out.println("Overview Of Festivals");
        activity.displayOverview();
        try
        {
           activity.planActivity();
        }
        catch(InvalidGuestCountException e)
        {
         System.out.println("Planning Warning (Guests): " + e.getMessage());
        }
        catch(BudgetExceededException e)
        {
         System.out.println("Planning Warning (Budget): " + e.getMessage());
        }
        catch(NoRouteException e)
        {
         System.out.println("Planning Warning (Routes): " + e.getMessage());
        }
        catch(FestivalPlanningException e)
        {
         System.out.println("General Planning Error: " +e.getMessage());
        }
      }
   }
   public static void main(String[] args)
   {
      List<FestivalActivity> activities = new ArrayList<>();
      activities.add(new TikaCeremony( 5000,6, "Shyam Chhetri"));
      activities.add(new TikaCeremony(60000, 33, null));
      activities.add(new TikaCeremony(40000, 0, "Anmol"));
      activities.add(new DeusiBhailo(4000,Arrays.asList("Buspark","Chakrapath","Lazimpat"), 9));
      activities.add(new DeusiBhailo(4000,new ArrayList<>(), 5));
      activities.add(new DeusiBhailo(15000, Arrays.asList("Chakrapath"), 2));
      executeFestivalPlan(activities);
   }
}
