public class View implements ViewInterface{

    private RegistrationCatalogDAO registrationCatalogDAO;
    private BufferedReader consoleReader;

    View(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
	    this.registrationCatalogDAO = registrationCatalogDAO;
	    this.consoleReader = consoleReader
    }
}
