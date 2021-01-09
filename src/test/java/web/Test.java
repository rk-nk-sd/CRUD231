//package web;
//
//import org.junit.Before;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import web.controller.UsersController;
//import web.service.UserService;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class Test {
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new UsersController(UserService userService)).build();
//    }
//
//    @Test
//    public void testHomePage() throws Exception {
//        this.mockMvc.perform(get("/all")).andExpect(status().isOk())
//                .andExpect(content().string("This is Home page"));
//    }
//
//    @Test
//    public void testHelloPage() throws Exception {
//        this.mockMvc.perform(get("/index")).andExpect(status().isOk())
//                .andExpect(content().string("Hello there!"));
//    }
//}
