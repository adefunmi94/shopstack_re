/**
 * 
 */
package com.shopsatck.controller.businessoutletTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

 import com.shopstack.dao.business.BusinessDaoImpl;
import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.service.business.BusinessService;

/**
 * @author Adefunmi
 *
 */

@ContextConfiguration("file:src/main/webapp/WEB-INF/web-layer-context-servlet.xml")
@RunWith(SpringRunner.class)
public class BusinessOutletControllerTest {

	@Mock
	private BusinessService busienssServiceImpl;
	
	
	@Autowired
	private BusinessDaoImpl businessDaoImpCont;
	
	@Before
	public void setUp() throws Exception {
		
		busienssServiceImpl = mock(BusinessService.class);
	}
	@Test
	public void checkBusinessOutletExistTest() {
		assertNotNull(busienssServiceImpl);
		assertNotNull(businessDaoImpCont);
	}


	@Test
	public void saveNewBusinessOutletTest() {

		BusinessOutlet newBusinessOutlet = new BusinessOutlet();
		
		doNothing().when(busienssServiceImpl).saveBusinessOutlet(isA(BusinessOutlet.class));
		busienssServiceImpl.saveBusinessOutlet(newBusinessOutlet);
		
		verify(busienssServiceImpl, times(1)).saveBusinessOutlet(newBusinessOutlet);
		
		int id = newBusinessOutlet.getOutletId();
		
		busienssServiceImpl.findOutletById(id);
		assertEquals(1, id);
	}
	
}
