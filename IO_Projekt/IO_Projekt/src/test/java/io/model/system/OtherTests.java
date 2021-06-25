package io.model.system;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OtherTests {
    
    public OtherTests() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void otherTestsV1() 
    {
        LocalTime lt = LocalTime.parse("08:00");
        System.out.println("Test porownywania czasow");
        System.out.println(lt.compareTo(LocalTime.parse("07:00")));
        System.out.println(lt.compareTo(LocalTime.parse("08:00")));
        System.out.println(lt.compareTo(LocalTime.now()));
    }
}
