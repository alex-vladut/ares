import org.ares.domain.activity.impl.ActivityDomainImpl;
import org.ares.domain.model.activity.ActivityEntity;
import org.ares.domain.user.impl.UserDomainImpl;
import org.ares.domain.validation.impl.GenericValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

beans{
	importBeans('classpath:/spring/persistence-context.groovy');
	
	validator(LocalValidatorFactoryBean);
	activityValidator(GenericValidator, ref('validator'));
	activityDomain(ActivityDomainImpl, ref('activityPersistence'), ref('activityValidator'));
	userDomain(UserDomainImpl, ref('userPersistence'));
}