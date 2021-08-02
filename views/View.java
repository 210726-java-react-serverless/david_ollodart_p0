public class View {

    private RegistrationCatalogDAO registrationCatalogDAO;
    private BufferedReader consoleReader;

    View(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
	    this.registrationCatalogDAO = registrationCatalogDAO;
	    this.consoleReader = consoleReader
    }
}
