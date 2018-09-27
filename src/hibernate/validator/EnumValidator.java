package hibernate.validator;

import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import hibernate.validator.enums.CaseMode;

public class EnumValidator implements ConstraintValidator<EnumConstraint, Integer> {

	private ArrayList<Enum> enumList = null;
	
	private int criteria;

	  @Override
	  public void initialize(EnumConstraint constraintAnnotation) {
		  
		  criteria = constraintAnnotation.value();
		  
		 /* enumList = new ArrayList<Enum>();
		  
		  Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();
		  
		  @SuppressWarnings("rawtypes")
		  Enum[] enumValArr = enumClass.getEnumConstants();
		  
		 
		  for(@SuppressWarnings("rawtypes")
		  Enum enumVal : enumValArr) {
			  enumList.add(enumVal);
		  }
		   */
	  }
	
    @Override
    public boolean isValid(Integer val, ConstraintValidatorContext arg1) {
    	if(val == criteria ){
    		return false;
    	}else{
    		return true;
    	}
    }

}