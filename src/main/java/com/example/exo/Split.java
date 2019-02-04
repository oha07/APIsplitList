package com.example.exo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Split {
	
	@PostMapping("/partitioner")
	   	    public  List<List<Integer>> partition(@RequestBody Data data) throws Exception {
	    	int splitSize =data.getSplitSize();

	    	List<Integer> inputList = data.getListInt();
	    	return splitListe(inputList,splitSize);
	    }

		public static List<List<Integer>> splitListe(List<Integer> inputList,int splitSize) throws Exception {
			if (inputList == null || inputList.isEmpty()) {
	           return null;
	        }
	        if (splitSize <1) {
	           throw new Exception("le paramètre splitSize doit etre superieur ou égale à 1");
	        }
	        
	        final AtomicInteger counter = new AtomicInteger(0);

	        final List<List<Integer>> partitioned = inputList.stream()
	                .collect(Collectors.groupingBy(it -> 
	                       counter.getAndIncrement() / splitSize
	                ))
	                .values().stream().collect(Collectors.toCollection((ArrayList::new)));
	    
	    return partitioned;
		}
	
	    
}
