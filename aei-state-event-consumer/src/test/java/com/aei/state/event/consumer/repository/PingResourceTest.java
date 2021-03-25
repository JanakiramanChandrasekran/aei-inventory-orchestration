/**
 * 
 */
package com.aei.state.event.consumer.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aei.state.event.consumer.resource.PingResource;

/**
 * Tests for {@link PingResource}
 *
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class PingResourceTest {

	@InjectMocks
	private PingResource resource;

	/**
	 * {@link PingResource#health()}
	 */
	@Test
	public void healthTest() {
		assertEquals(Boolean.TRUE, resource.health());
	}

}
