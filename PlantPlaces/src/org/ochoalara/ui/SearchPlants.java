package org.ochoalara.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.ochoalara.dto.Plant;
import org.ochoalara.service.IPlantService;
import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {
	
	@Inject
	private Plant plant;
	
	@Inject
	private IPlantService plantService;
	
	
	public String results(){
		if(plant!=null && plant.getName().equalsIgnoreCase("Redbud")){
			return "search";
		}else{
			return "noresults";
		}
	}

	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	public List<Plant> completePlants(String query){
		System.out.println("query: " + query);
		return plantService.filterPlants(query);		 		
	}
}
