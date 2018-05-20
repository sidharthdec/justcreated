package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdjustmentDetails;
import com.example.demo.model.AfterAdjustmentDetails;
import com.example.demo.model.BatchDetails;

@RestController
public class BatchAdjustmentImpl implements BatchAdjustment{

	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private Batches batches;
	
	@Autowired
	private Adjustment adjustment;
	
	@Autowired
	private Validation validation;
	
	//get entries from file 
		public <FileDetails> void getFile(FileDetails fd) {
			fileUpload.readFile();
		}
		//run batch
		public void runBatch(BatchDetails bd) {
			batches.runbatch();
		}
		//run adjustment
		public void runAdjustment(AdjustmentDetails ad) {
			adjustment.runAdjustment();
		}
		//validate they were adjusted
		public void validate(AfterAdjustmentDetails aad) {
			validation.validate();
		}
	
	
	
	
}
