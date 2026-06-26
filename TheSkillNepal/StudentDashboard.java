package TheSkillNepal;

public class StudentDashboard
{
  void displayCourseStatus(String studentId , String courseId, EligibilityRule rule)
  {
    System.out.println("Checking enrollment status for " + studentId + " in " + courseId + "....");
    try{
        boolean eligible = rule.isEligible(studentId, courseId);
        if(eligible)
        {
            System.out.println("You are enroled! Access course materials now.");
        }
    }
    catch(EnrollmentDeniedException e)
    {
        System.out.println("Enrollment denied: " + e.getMessage() + " . Please contact support");
    }
    finally
    {
        System.out.println("Status check completed for " +studentId + " .");
    }
  } 
  public static void main(String[] args)
  {
    StudentDashboard sd = new StudentDashboard();
    EligibilityRule erule = (studentId , courseId) ->
    {
       if(studentId.equals("SKILL123") && courseId.equals("JAVA101"))
       {
        return true;
       }
       if(!studentId.equals("STUDENT001") && courseId.equals("JAVA101"))
       {
        throw new EnrollmentDeniedException("Invalid Id format");
       }
       if(studentId.equals("SKILL999") && courseId.equals("PYTHON202"))
       {
        throw new EnrollmentDeniedException("Student Id suspended");
       }
       return false;
    };
        sd.displayCourseStatus("SKILL123", "JAVA101", erule);
        sd.displayCourseStatus("SKILL999", "PYTHON101", erule);
        sd.displayCourseStatus("STD101", "JAVA101", erule);
  }  
}
