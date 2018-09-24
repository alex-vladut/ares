import org.ares.controller.activity.ActivityController;
import org.ares.controller.exception.handler.GlobalExceptionHandler;
import org.ares.controller.login.UserController;
import org.springframework.context.support.ResourceBundleMessageSource;

beans{
	importBeans('classpath:/spring/facade-context.groovy');
	
	activityController(ActivityController, ref('activityFacade'));
	userConController(UserController, ref('userFacade'));
	messageSource(ResourceBundleMessageSource){
	    basename = "locale/error_messages"
	    defaultEncoding = "UTF-8"
	}
	exceptionHandler(GlobalExceptionHandler, ref('messageSource'));
}