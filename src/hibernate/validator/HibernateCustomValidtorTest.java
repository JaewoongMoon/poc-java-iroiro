package hibernate.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import hibernate.validator.domain.Car;
import hibernate.validator.enums.CaseMode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;


public class HibernateCustomValidtorTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUp(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
    public void testLicensePlateNotUpperCase() {

        Car car = new Car("Morris", "dd-ab-123", 4);
        car.setMode(CaseMode.NONE); // NONE이 아닐 경우만 통과 시키기 
        
        
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        assertEquals(1, constraintViolations.size());
        assertEquals("Case mode must not be NONE.", constraintViolations.iterator().next().getMessage());
    }
	
	
    @Test
    public void carIsValid() {

        Car car = new Car("Morris", "DD-AB-123", 4);
        car.setMode(CaseMode.LOW);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertEquals(0, constraintViolations.size());
    }

}
