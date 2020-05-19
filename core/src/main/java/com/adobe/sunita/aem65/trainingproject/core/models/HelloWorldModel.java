
package com.adobe.sunita.aem65.trainingproject.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class HelloWorldModel {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldModel.class);

	@ValueMapValue(name = PROPERTY_RESOURCE_TYPE, injectionStrategy = InjectionStrategy.OPTIONAL)
	@Default(values = "No resourceType")
	protected String resourceType;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	protected String navigationBackGroundColor;

	public String getNavigationBackGroundColor() {
		LOGGER.info("navigationBackGroundColor **************** ======++++++====    " + navigationBackGroundColor);

		if (navigationBackGroundColor != null) {
			int r = Integer.valueOf(navigationBackGroundColor.substring(1, 3), 16);
			LOGGER.info("r in RGB  ====== " + r);
			int g = Integer.valueOf(navigationBackGroundColor.substring(3, 5), 16);
			LOGGER.info("g in RGB  ====== " + g);
			int b = Integer.valueOf(navigationBackGroundColor.substring(5, 7), 16);
			LOGGER.info("b in RGB  ====== " + b);
			navigationBackGroundColor = r + "," + g + "," + b;
			LOGGER.info("bgcolor  in RGB   ======*****  " + navigationBackGroundColor);

		}
		return this.navigationBackGroundColor;

	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
