package pharmacymanagementpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

//BundleActivaror implementation for managing to lifecycle of Pharmacy Publisher
public class PharmacyActivator implements BundleActivator {

	
	ServiceRegistration publishServiceRegistration;
	
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Pharmacy Publisher");
		//Creating an object of PharmacyPublisher Implementation
		PharmacyPublisher publishService = new PharmacyPublishImpl();
		
		//Registering the PharmacyPublisher service 
		publishServiceRegistration = context.registerService(PharmacyPublisher.class.getName(),publishService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop pharmacy Publisher");
		
		//UnRegistering the PharmacyPublisher service 
		publishServiceRegistration.unregister();
	}

}
