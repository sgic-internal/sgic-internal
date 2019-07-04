package com.sgic.internal.defecttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.sgic.internal.defecttracker.defect.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class DefectTrackerApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(DefectTrackerApplication.class, args);
    }
}
