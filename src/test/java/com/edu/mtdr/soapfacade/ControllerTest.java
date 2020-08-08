package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.controller.JsonController;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonRequestMessage;
import com.edu.mtdr.soapfacade.model.soapMsgs.AddResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.DivideResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.MultiplyResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.SubtractResponse;
import com.edu.mtdr.soapfacade.service.ISoapClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ISoapClientService soapClientService;

    @Test
    public void testMultiply() throws Exception {
        CalcJsonRequestMessage req = new CalcJsonRequestMessage(5, 1);
        MultiplyResponse response = new MultiplyResponse();
        response.setMultiplyResult(5);
        given(soapClientService.getMultiplyResult(req.getA(), req.getB())).willReturn(response);

        this.mvc.perform(post("/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("statusCode").value(200))
                .andExpect(jsonPath("result").value(response.getMultiplyResult()));
    }

    @Test
    public void testAddition() throws Exception {
        CalcJsonRequestMessage req = new CalcJsonRequestMessage(5, 1);
        AddResponse response = new AddResponse();
        response.setAddResult(6);
        given(soapClientService.getAdditionResult(req.getA(), req.getB())).willReturn(response);

        this.mvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("statusCode").value(200))
                .andExpect(jsonPath("result").value(response.getAddResult()));
    }

    @Test
    public void testDivide() throws Exception {
        CalcJsonRequestMessage req = new CalcJsonRequestMessage(6, 2);
        DivideResponse response = new DivideResponse();
        response.setDivideResult(3);
        given(soapClientService.getDivideResult(req.getA(), req.getB())).willReturn(response);

        this.mvc.perform(post("/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("statusCode").value(200))
                .andExpect(jsonPath("result").value(response.getDivideResult()));
    }

    @Test
    public void testSubtract() throws Exception {
        CalcJsonRequestMessage req = new CalcJsonRequestMessage(6, 2);
        SubtractResponse response = new SubtractResponse();
        response.setSubtractResult(4);
        given(soapClientService.getSubtractResult(req.getA(), req.getB())).willReturn(response);

        this.mvc.perform(post("/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(req)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("statusCode").value(200))
                .andExpect(jsonPath("result").value(response.getSubtractResult()));
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
