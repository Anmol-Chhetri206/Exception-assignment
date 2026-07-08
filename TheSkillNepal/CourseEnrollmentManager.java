package TheSkillNepal;
public class CourseEnrollmentManager 
{
    public static void enrollStudent(String studentId, String courseId,EligibilityRule rule)
    {
        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "....");
        try{
          if(rule.isEligible(studentId, courseId))
          {
            System.out.println("Enrollment Successful for " +studentId + "in" + courseId + "!Happy Learning");
          }
          else{
            System.out.println(studentId + " is not eligible for " + courseId + "'");
          }
        }
        catch(EnrollmentDeniedException e)
        {
            System.out.println("Enrollment failed for " + studentId + ": " +e.getMessage() );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        EligibilityRule rule = (studentId , couse)
    }
}
