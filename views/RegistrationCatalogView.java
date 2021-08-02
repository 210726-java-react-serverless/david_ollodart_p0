public class RegistrationCatalogView{

    private RegistrationCatalogDAO registrationCatalogDAO;
    private String route;

    RegistrationCatalogView(registrationCatalogDAO, route) {
	    this.registrationCatalogDAO = registrationCatalogDAO;
	    this.route = route;
    }

}
