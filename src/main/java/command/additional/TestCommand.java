package command.additional;

import command.ICommand;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class TestCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = PagesManager.getInstance().getProperty(
				PagesManager.TEST_PAGE);
		return page;
	}
}
