package com.example.demo.controller;

import com.example.demo.model.AdjustmentDetails;
import com.example.demo.model.AfterAdjustmentDetails;
import com.example.demo.model.BatchDetails;

public interface BatchAdjustment {

	//get entries from file 
			public <FileDetails> void getFile(FileDetails fd);
			//run batch
			public void runBatch(BatchDetails bd);
			//run adjustment
			public void runAdjustment(AdjustmentDetails ad);
			//validate they were adjusted
			public void validate(AfterAdjustmentDetails aad);
}
