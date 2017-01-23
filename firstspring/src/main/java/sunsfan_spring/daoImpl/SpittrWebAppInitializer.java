package sunsfan_spring.daoImpl;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import sunsfan_spring.config.RootConfig;
import sunsfan_spring.config.WebConfig;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
