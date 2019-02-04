package com.example.exo;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciceJavaApplicationTests {
			
		@Autowired
		private MockMvc mockMvc;

		@Test
		public void shouldAnswerWithTrue() throws Exception
	    {
			String requestedData = "{\"splitSize\":2,\"listInt\":[1,2,3,4]}";
			String expectedData = "[[1,2],[3,4]]";
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/partitioner")
					.accept(MediaType.APPLICATION_JSON).content(requestedData)
					.characterEncoding("utf-8")
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			System.out.println("###type content:"+response.getContentType());
			System.out.println("###content:"+response.getContentAsString());
			assertEquals(response.getContentAsString(),expectedData);

	    }
	    

	@Test
	public void test() throws Exception {

        TestCase.assertNull(Split.splitListe(null, 3));
        TestCase.assertNull(Split.splitListe(new ArrayList<>(), 3));
       
       List<Integer> intList = Arrays.asList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);
           try {
                List<List<Integer>> result = Split.splitListe(intList, 0);
                Assert.fail();
           } catch (Exception e) {
               Assert.assertEquals(e.getMessage(), "le paramètre splitSize doit etre superieur ou égale à 1");
           }
           
        List<List<Integer>> result = Split.splitListe(intList, 3);

        Assert.assertEquals(4, result.size());
        
       List<Integer> s1 = Arrays.asList(1, 2, 3);
       List<Integer> s2 = Arrays.asList(0, 4, 5);
       List<Integer> s3 = Arrays.asList(6, 0, 7);
       List<Integer> s4 = Arrays.asList(8);

        Assert.assertEquals(s1, result.get(0));
        Assert.assertEquals(s2, result.get(1));
        Assert.assertEquals(s3, result.get(2));
        Assert.assertEquals(s4, result.get(3));
    }

}

