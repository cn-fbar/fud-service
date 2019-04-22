package cs.io.fudservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SetupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SetupController setupController;

    @Before
    public void setup() {
       // setupController.createTestData();
    }

    @Test
    public void testSetupTestData() throws Exception {
        mockMvc.perform(get("/setup/init"))

                .andExpect(status().isOk())
                .andExpect(content().string("Initial Setup data created."));
        ;
    }

    @Test
    public void testClearData() throws Exception {
        mockMvc.perform(get("/setup/clear"))
                .andExpect(status().isOk())
                .andExpect(content().string("Data cleared.."));
    }
}
