package servlet;

public class AutoparkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommandFactory requestHelper = CommandFactory.getInstance();
    private String page = ConfigurationManager.getInstance().getProperty(
            ConfigurationManager.INDEX_PAGE_PATH);
    private Logger log = Logger.getLogger(LibraryServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryServlet() {
        super();
    }

    /**
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("initializing log4j");
        String log4jLocation = config
                .getInitParameter("log4j-properties-location");

        ServletContext sc = config.getServletContext();

        if (log4jLocation == null) {
            System.err
                    .println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
            BasicConfigurator.configure();
        } else {
            String webAppPath = sc.getRealPath("/");
            String log4jProp = webAppPath + log4jLocation;
            File propFile = new File(log4jProp);
            if (propFile.exists()) {
                System.out.println("Initializing log4j with: " + log4jProp);
                PropertyConfigurator.configure(log4jProp);
            } else {
                System.err
                        .println("*** "
                                + log4jProp
                                + " file not found, so initializing log4j with BasicConfigurator");
                BasicConfigurator.configure();
            }
        }
        super.init(config);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    public void processRequest(HttpServletRequest request,
                               HttpServletResponse response) {

        ICommand command = requestHelper.getCommand(request);
        String nextPage = null;
        nextPage = command.execute(request);
        if (!"ref".equals(nextPage))
            page = nextPage;
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(page);
        try {

            dispatcher.forward(request, response);
        } catch (ServletException e) {
            log.error("Servlet exception " + e.getMessage());
        } catch (IOException e) {
            log.error("IO exception " + e.getMessage());
        }

    }
}
