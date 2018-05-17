package command;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

public interface ICommand {

    static Logger log = Logger.getLogger(ICommand.class);
    public void execute(HttpServletRequest request);
}