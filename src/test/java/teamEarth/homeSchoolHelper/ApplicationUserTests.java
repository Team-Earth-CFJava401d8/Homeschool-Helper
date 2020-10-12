package teamEarth.homeSchoolHelper;

//import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;
//import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.Assert.*;



public class ApplicationUserTests {

    @Test
    public void applicationUserCreationEmptyTest() {
        ApplicationUser applicationUserTest = new ApplicationUser();
        assertNull("this should be null", applicationUserTest.getFirstName());
    }

    @Test
    public void createApplicationUser() {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setFirstName("Paul");
        applicationUser.setLastName("O'Brien");
        applicationUser.setUserName("MxPxP86");
        applicationUser.setBio("Just a guy.");
//        applicationUser.setDateOfBirth(); // https://stackoverflow.com/questions/2305973/java-util-date-vs-java-sql-date c'mon guys...
        System.out.println(applicationUser.toString());
        assertEquals("This is a user created.", "ApplicationUser{userName: MxPxP86 | firstName: Paul | lastName: O'Brien | dateOfBirth: null | bio: Just a guy.}", applicationUser.toString() );
    }
}

