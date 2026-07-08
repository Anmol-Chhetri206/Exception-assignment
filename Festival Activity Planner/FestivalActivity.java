class FestivalPlanningException extends Exception
{
   public FestivalPlanningException(String message)
   {
   super(message);
   }
}
public abstract class FestivalActivity
{
   String activityName;
   double estimatedCost;
   public FestivalActivity(String activitiyName , double cost)
   {
    this.activityName = activitiyName;
    this.estimatedCost = cost;
   }
   public abstract void planActivity() throws FestivalPlanningException;

   public void displayOverview()
   {
      System.out.println("Name of Activity: "+activityName);
      System.out.println("Estimated Cost:  "+estimatedCost);
   }

}