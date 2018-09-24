import org.apache.commons.dbcp.BasicDataSource
import org.ares.persistence.activity.impl.ActivityPersistenceImpl
import org.ares.persistence.repository.ActivityRepository;
import org.ares.persistence.repository.UserRepository
import org.ares.persistence.user.impl.UserPersistenceImpl
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter

def loadPropertiesFile(String fileName){
    final Properties properties = new Properties()
    final InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)
    properties.load(is)
    
    return properties
}

final Properties datasourceProps = loadPropertiesFile("database/database.properties");
final Properties hibernateProps = loadPropertiesFile("database/hibernate.properties");

beans{
    dataSource(BasicDataSource) {
	driverClassName = datasourceProps.getProperty("datasource.driverClass")
	url = datasourceProps.getProperty("datasource.URL")
	username = datasourceProps.getProperty("datasource.username")
	password = datasourceProps.getProperty("datasource.password")
    }
    hibernateJpaAdapter(HibernateJpaVendorAdapter);
    entityManagerFactory(LocalContainerEntityManagerFactoryBean){
	jpaVendorAdapter=hibernateJpaAdapter
	dataSource=dataSource
	persistenceUnitName="persistenceUnit"
	packagesToScan=[
	    "org.ares.domain.model"
	]
	jpaProperties=hibernateProps
    }
    transactionManager(JpaTransactionManager){  entityManagerFactory=entityManagerFactory  }
    userRepository(UserRepository);
    activityRepository(ActivityRepository);
    activityPersistence(ActivityPersistenceImpl, activityRepository);
    userPersistence(UserPersistenceImpl, userRepository);
}