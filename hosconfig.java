package com.hospital.hopitalCongig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class hosconfig
{
	@Bean
   public ModelMapper modelmapper()
   {
	 
		return new ModelMapper();
   }
}
