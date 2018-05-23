import command.CommandFactory;
import command.ICommand;
import manager.PagesManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoparkServlet extends HttpServlet {

    private CommandFactory commandFactory = CommandFactory.getInstance();
    private String page =PagesManager.getInstance().getProperty(PagesManager.INDEX_PAGE);
    private Logger log = Logger.getLogger(AutoparkServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in servlet");
        ICommand command = commandFactory.getCommand(request);
        String nextPage = null;
        nextPage = command.execute(request);
        System.out.println(nextPage);
/*        if (!"ref".equals(nextPage))
            page = nextPage;*/
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(nextPage);
        try {

            dispatcher.forward(request, response);
        } catch (ServletException e) {
            log.error("Servlet exception " + e.getMessage());
        } catch (IOException e) {
            log.error("IO exception " + e.getMessage());
        }
    }
}
