package com.adobe.training.summit.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Model(adaptables = Resource.class)
public class LandingPosterCarouselModel {
	
	private static Logger LOG = LoggerFactory.getLogger(LandingPosterCarouselModel.class);
	
	@Inject
    @Optional
	private List<Map<String, String>> slidesList = new ArrayList<Map<String, String>>();		
	private String flag = "flase";
	
	@PostConstruct
	public void activate() throws Exception {
	    	Resource currentResource = getResource();	    	
	    	Resource multifieldPropRes = currentResource.getChild("NestedSlides");	    	
	    	if(multifieldPropRes != null) {
	    		Iterator<Resource> itr = multifieldPropRes.listChildren();
	    		int count = 0;
	    		int index = 0;
		    	while (itr.hasNext()) {
					Resource childRes  = itr.next();
					ValueMap properties = childRes.getValueMap();
					Map<String,String> jsonMap = new HashMap<String,String>();
					
					LOG.info("properties123  ==  " + properties);
					
					
					if(properties.get("bgImage") != null) {
						jsonMap.put("bgImage", properties.get("bgImage").toString());
					}

					if(index >1) {
						flag = "true";
					}
					
					jsonMap.put("flag",flag);
					jsonMap.put("count", Integer.toString(count));
					count++;
					index++;
					slidesList.add(jsonMap);
				}
	    	}		
	}

	private Resource getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, String>> getSlidesList() {
		return slidesList;
	}
	
}



