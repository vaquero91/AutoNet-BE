package com.myTwitterAPI.autoNetBE;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(testRest.class)
@RunWith(SpringRunner.class)
class AutoNetBeApplicationTests {
        
        @Autowired
        private MockMvc mockMvc;
        
        @Test
        public void test() throws Exception {
            mockMvc.perform(get("/")).andExpect(status().isOk());
        }
	
                
    

}
