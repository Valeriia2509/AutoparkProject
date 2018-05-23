package manager;

import java.util.ResourceBundle;

public class PagesManager {
	private static PagesManager manager;
	private ResourceBundle resourceBundle;
	private static final String BUNDLE = "resources/pages";
	public static final String TEST_PAGE = "TEST_PAGE";
	public static final String INDEX_PAGE = "INDEX_PAGE";

	public static PagesManager getInstance() {
		if (manager == null) {
			manager = new PagesManager();
			manager.resourceBundle = ResourceBundle.getBundle(BUNDLE);
		}
		return manager;
	}

	public String getProperty(String key) {
		return (String) resourceBundle.getObject(key);
	}
}
