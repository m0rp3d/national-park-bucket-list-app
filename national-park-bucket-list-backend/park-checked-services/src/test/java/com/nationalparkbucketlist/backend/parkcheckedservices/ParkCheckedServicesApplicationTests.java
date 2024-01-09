package com.nationalparkbucketlist.backend.parkcheckedservices;

import com.nationalparkbucketlist.backend.parkcheckedservices.controller.ParkCheckedController;
import com.nationalparkbucketlist.backend.parkcheckedservices.entity.ParkChecked;
import com.nationalparkbucketlist.backend.parkcheckedservices.services.ParkCheckedService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParkCheckedServicesApplicationTests {

	@Autowired
	private ParkCheckedController parkCheckedController;

	@Autowired
	private ParkCheckedService parkCheckedService;

	@Mock
	private ParkCheckedController mockParkCheckerController = new ParkCheckedController();
	//@Mock
	//private ParkCheckedService mockParkCheckedService = new ParkCheckedService();

	@Test
	public void testGetAllParksChecked() {
		List<ParkChecked> allParksChecked;

		allParksChecked = parkCheckedController.getAllParksChecked();

		assertEquals(allParksChecked.isEmpty(), false);

	}

	// unfinished
	// throw exception when failing to get list of parkschecked
	@Test
	@Disabled
	public void willThrowGetAllParksChecked() {
		List<ParkChecked> allParksChecked;

		//when(allParksChecked = mockParkCheckerController.getAllParksChecked()).thenReturn(null);

		//System.out.println(allParksChecked);

		//assertEquals(allParksChecked.isEmpty(), true);
		assertThatThrownBy(() -> when(mockParkCheckerController.getAllParksChecked()).thenReturn(null)).
				isInstanceOf(RuntimeException.class)
				.hasMessageContaining("No parks checked");

	}

	/*
	@Test
	public void testGetParksCheckedByUserId() {
		List<ParkChecked> checkerList = new ArrayList<ParkChecked>();

		checkerList.add(new ParkChecked("Denali", "Alaska", false, 1, 1));
		checkerList.add(new ParkChecked("Gates of the Arctic", "Alaska", false, 1, 2));
		checkerList.add(new ParkChecked("Glacier Bay", "Alaska", false, 1, 3));
		checkerList.add(new ParkChecked("Katmai", "Alaska", false, 1, 4));
		checkerList.add(new ParkChecked("Kenai Fjords", "Alaska", false, 1, 5));
		checkerList.add(new ParkChecked("Kobuk Valley", "Alaska", false, 1, 6));
		checkerList.add(new ParkChecked("Lake Clark", "Alaska", false, 1, 7));
		checkerList.add(new ParkChecked("Wrangell - St. Elias", "Alaska", false, 1, 8));
		checkerList.add(new ParkChecked("American Samoa", "American Samoa", false, 1, 9));
		checkerList.add(new ParkChecked("Grand Canyon", "Arizona", false, 1, 10));
		checkerList.add(new ParkChecked("Petrified Forest", "Arizona", false, 1, 11));
		checkerList.add(new ParkChecked("Saguaro", "Arizona", false, 1, 12));
		checkerList.add(new ParkChecked("Organ Pipe Cactus", "Arizona", false, 1, 13));
		checkerList.add(new ParkChecked("Hot Springs", "Arkansas", false, 1, 14));
		checkerList.add(new ParkChecked("Channel Islands", "California", false, 1, 15));
		checkerList.add(new ParkChecked("Death Valley", "California", false, 1, 16));
		checkerList.add(new ParkChecked("Joshua Tree", "California", false, 1, 17));
		checkerList.add(new ParkChecked("Kings Canyon", "California", false, 1, 18));
		checkerList.add(new ParkChecked("Lassen Volcanic", "California", false, 1, 19));
		checkerList.add(new ParkChecked("Redwood", "California", false, 1, 20));
		checkerList.add(new ParkChecked("Sequoia", "California", false, 1, 21));
		checkerList.add(new ParkChecked("Yosemite", "California",false, 1, 22));
		checkerList.add(new ParkChecked("Black Canyon of the Gunnison", "Colorado", false, 1, 23));
		checkerList.add(new ParkChecked("Great Sand Dunes", "Colorado", false, 1, 24));
		checkerList.add(new ParkChecked("Mesa Verde", "Colorado", false, 1, 25));
		checkerList.add(new ParkChecked("Rocky Mountain", "Colorado", false, 1, 26));
		checkerList.add(new ParkChecked("Biscayne", "Florida", false, 1, 27));
		checkerList.add(new ParkChecked("Dry Tortugas", "Florida", false, 1, 28));
		checkerList.add(new ParkChecked("Everglades", "Florida", false, 1, 29));
		checkerList.add(new ParkChecked("Haleakala", "Hawaii", false, 1, 30));
		checkerList.add(new ParkChecked("Hawaii Volcanoes", "Hawaii", false, 1, 31));
		checkerList.add(new ParkChecked("Yellowstone", "Idaho", false, 1, 32));
		checkerList.add(new ParkChecked("Mammoth Cave", "Kentucky", false, 1, 33));
		checkerList.add(new ParkChecked("Isle Royale", "Michigan", false, 1, 34));
		checkerList.add(new ParkChecked("Voyageurs", "Minnesota",false, 1, 35));
		checkerList.add(new ParkChecked("Glacier", "Montana", false, 1, 36));
		checkerList.add(new ParkChecked("Great Basin", "Nevada", false, 1, 37));
		checkerList.add(new ParkChecked("Carlsbad Caverns", "New Mexico", false, 1, 38));
		checkerList.add(new ParkChecked("Great Smoky Mountains", "North Carolina",false, 1, 39));
		checkerList.add(new ParkChecked("Theodore Roosevelt", "North Dakota", false, 1, 40));
		checkerList.add(new ParkChecked("Cuyahoga Valley", "Ohio", false, 1, 41));
		checkerList.add(new ParkChecked("Crater Lake", "Oregon", false, 1, 42));
		checkerList.add(new ParkChecked("'Congaree'", "South Carolina", false, 1, 43));
		checkerList.add(new ParkChecked("Badlands", "South Dakota", false, 1, 44));
		checkerList.add(new ParkChecked("Wind Cave", "South Dakota", false, 1, 45));
		checkerList.add(new ParkChecked("Great Smoky Mountains", "Tennessee", false, 1, 46));
		checkerList.add(new ParkChecked("Big Bend", "Texas", false, 1, 47));
		checkerList.add(new ParkChecked("Guadalupe Mountains", "Texas", false, 1, 48));
		checkerList.add(new ParkChecked("Virgin Islands", "United States Virgin Islands", false, 1, 49));
		checkerList.add(new ParkChecked("Arches", "Utah", false, 1, 50));
		checkerList.add(new ParkChecked("Bryce Canyon", "Utah", false, 1, 51));
		checkerList.add(new ParkChecked("Canyonlands", "Utah", false, 1, 52));
		checkerList.add(new ParkChecked("Capitol Reef", "Utah", false, 1, 53));
		checkerList.add(new ParkChecked("Zion", "Utah", false, 1, 54));
		checkerList.add(new ParkChecked("Shenandoah", "Virginia", false, 1, 55));
		checkerList.add(new ParkChecked("Mount Rainier", "Washington", false, 1, 56));
		checkerList.add(new ParkChecked("North Cascades", "Washington", false, 1, 57));
		checkerList.add(new ParkChecked("Olympic", "Washington", false, 1, 58));
		checkerList.add(new ParkChecked("Grand Teton", "Wyoming", false, 1, 59));
		checkerList.add(new ParkChecked("Yellowstone", "Wyoming", false, 1, 60));

		when(mockParkCheckedService.returnUsersParkCheckedList("origin", "origin")).thenReturn(checkerList);

		//List<ParkChecked> tempList = parkCheckedService.returnUsersParkCheckedList("origin", "origin");

		assertEquals(4, checkerList.get(3).getUserId());
	}

	 */

}
