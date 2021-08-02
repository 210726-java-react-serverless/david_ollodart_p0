public class LoginView{

    private RegistrationCatalogDAO registrationCatalogDAO;
    private String route;

    RegistrationCatalogView(registrationCatalogDAO, route) {
	    this.registrationCatalogDAO = registrationCatalogDAO;
	    this.route = route;
    }

}
