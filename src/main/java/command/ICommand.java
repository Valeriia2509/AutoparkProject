package command;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

public interface ICommand {

    Logger log = Logger.getLogger(ICommand.class);
    String execute(HttpServletRequest request);
}