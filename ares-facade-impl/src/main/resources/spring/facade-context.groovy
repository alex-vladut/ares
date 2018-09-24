import org.ares.facade.activity.impl.ActivityFacadeImpl;
import org.ares.facade.mapper.MapperAdapter;
import org.ares.facade.user.impl.UserFacadeImpl;
import org.dozer.DozerBeanMapper;

beans{
	importBeans('classpath:/spring/domain-context.groovy');
	
	mapper(DozerBeanMapper);
	mapperAdapter(MapperAdapter, ref('mapper'));
	activityFacade(ActivityFacadeImpl, ref('activityDomain'), ref('mapperAdapter'));
	userFacade(UserFacadeImpl, ref('userDomain'));
}