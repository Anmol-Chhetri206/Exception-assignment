package TheSkillNepal;
public class CourseEnrollmentManager 
{
    public static void enrollStudent(String studentId, String courseId,EligibilityRule rule)
    {
        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "....");
        try 
        {
          boolean eligible = rule.isEligible(studentId, courseId);
          if(eligible)
          {
            System.out.println("Enrollment successful for " + studentId + "in" + courseId + "!Happy Learning!");
          }
        }
        catch(EnrollmentDeniedException e)
        {
          System.out.println("Enrollment failed for " + studentId + ": " +e.getMessage());
        }
    }
    public static void main(String[] args) 
    {
      EligibilityRule erule = (studentId,courseId) ->
      {
        if(studentId.equalsIgnoreCase("Skill999"))
        {
          throw new EnrollmentDeniedException("Student account suspended due to outstanding fees, Roshan!");
        }
        if(courseId.equalsIgnoreCase("JAVA101") && !studentId.startsWith("SKILL"))
        {
          throw new EnrollmentDeniedException("Invalid student ID format. Please use 'SKILL' prefix, Anisha!");
        }
        if(studentId.startsWith("SKILL") && courseId.equals("JAVA101"))
        {
          return true;
        }
        return false;
      };
      enrollStudent("Student2", "Data Sciece", erule);
      enrollStudent("SKILL202", "JAVA101", erule);
      enrollStudent("SKILL999", "PYTHON", erule);
      enrollStudent("SKILL101", "JAVA101", erule);
    }
}
