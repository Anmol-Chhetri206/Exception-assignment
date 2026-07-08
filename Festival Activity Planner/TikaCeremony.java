public class TikaCeremony extends FestivalActivity
{
    int expectedGuests;
    String mainFamilyElder;
    public TikaCeremony (double cost,int expectedGuests,String mainFamilyElder )
    {
        super("Tika Ceremony",cost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
       
    }
    public static void main(String[] args) 
    {
        TikaCeremony[] tc = { new TikaCeremony(60000,4,"Dev Kumari Chhetri"),
            new TikaCeremony(4000,5, null),
            new TikaCeremony(30000, 7, "Shyam Chhetri")
        };
        for(TikaCeremony t: tc)
        try
        {
            t.displayOverview();
            t.planActivity();
        }
        catch(InvalidGuestCountException e)
        {
            System.out.println(e.getMessage());
        }
        catch(BudgetExceededException e)
        {
            System.out.println(e.getMessage());
        }
        catch(FestivalPlanningException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void planActivity() throws FestivalPlanningException
    {
       if(expectedGuests < 5)
       {
          throw new InvalidGuestCountException ("Not Enough guests for a lively Tika! Is Everyone on vacation?...");
       } 
       if(estimatedCost >= 50000)
       {
        throw new BudgetExceededException("Tika budget is too high! Is this for the whole village?...");
       }

       System.out.println(activityName +"with " + mainFamilyElder + " planned successfully for " + expectedGuests + " guests!");

    };
}
class InvalidGuestCountException extends FestivalPlanningException
{
    public InvalidGuestCountException(String message)
    {
        super(message);
    }
}
class BudgetExceededException extends FestivalPlanningException
{
    public BudgetExceededException(String message)
    {
        super(message);
    }
}
