package com.lopessystem.pocimproveapi.resource;

import com.lopessystem.pocimproveapi.config.ResourceTestConfig;
import com.lopessystem.pocimproveapi.exceptions.EntityNotFoundException;
import com.lopessystem.pocimproveapi.util.PersonResourceTestSupport;
import com.lopessystem.pocimproveapi.util.SerializeJsonResourceTestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Person resource test.
 */
@WebMvcTest(PersonResource.class)
public class PersonResourceTest extends ResourceTestConfig {

    /**
     * The Person manager.
     */
    @MockBean
    private PersonManager personManager;

    /**
     * When find all person then return ok.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenFindAllPersonThenReturnOK() throws Exception {

        Page<Person> personPage = new PageImpl(PersonResourceTestSupport.getPersonList());

        Mockito.when(personManager.findAll(Mockito.any())).thenReturn(personPage);

        mockMvc.perform((get("/v1/people").contentType(MediaType.APPLICATION_JSON))).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Mother Person Name")))
                .andExpect(content().string(containsString("totalElements\":1")));

        Mockito.verify(personManager).findAll(Mockito.any());
    }

    /**
     * When find by id then return ok.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenFindByIdThenReturnOK() throws Exception {

        Person person = PersonResourceTestSupport.createPerson();

        Mockito.when(personManager.findById(Mockito.any())).thenReturn(person);

        mockMvc.perform((get("/v1/people/{personId}", 1L).contentType(MediaType.APPLICATION_JSON))).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Person Test")))
                .andExpect(content().string(containsString("id\":1")));

        Mockito.verify(personManager).findById(Mockito.any());
    }

    /**
     * When find by id then return bad request.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenFindByIdThenReturnBadRequest() throws Exception {

        Mockito.when(personManager.findById(Mockito.any())).thenThrow(EntityNotFoundException.class);

        mockMvc.perform((get("/v1/people/{personId}", 0L).contentType(MediaType.APPLICATION_JSON))).andDo(print())
                .andExpect(status().isNotFound());

        Mockito.verify(personManager).findById(Mockito.any());
    }

    /**
     * Given person when create then return is created.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenCreateThenReturnIsCreated() throws Exception {

        Person personMock = PersonResourceTestSupport.createPerson();
        personMock.setId(null);

        Mockito.when(personManager.create(Mockito.any())).thenReturn(personMock);

        mockMvc.perform((post("/v1/admin/people").contentType(MediaType.APPLICATION_JSON))
                .content(SerializeJsonResourceTestSupport.convertObjectToJsonBytes(personMock))).andDo(print())
                .andExpect(status().isCreated()).andExpect(content().string(containsString("Person Test")));

        Mockito.verify(personManager, times(1)).create(Mockito.any());
    }

    /**
     * Given person when create then return bad request.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenCreateThenReturnBadRequest() throws Exception {

        Person personMock = new Person();

        mockMvc.perform((post("/v1/admin/people").contentType(MediaType.APPLICATION_JSON))
                .content(SerializeJsonResourceTestSupport.convertObjectToJsonBytes(personMock))).andDo(print())
                .andExpect(status().isBadRequest());

        Mockito.verify(personManager, times(0)).create(Mockito.any());
    }

    /**
     * Given person when update then return ok.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenUpdateThenReturnOK() throws Exception {

        Person personMock = PersonResourceTestSupport.createPerson();

        mockMvc.perform((put("/v1/people/{personId}", 1L).contentType(MediaType.APPLICATION_JSON))
                .content(SerializeJsonResourceTestSupport.convertObjectToJsonBytes(personMock))).andDo(print())
                .andExpect(status().isOk());

        Mockito.verify(personManager, times(1)).update(Mockito.anyLong(), Mockito.any());
    }

    /**
     * Given person when update then return bad request.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenUpdateThenReturnBadRequest() throws Exception {

        Person personMock = new Person();

        mockMvc.perform((put("/v1//people/{personId}", 1L).contentType(MediaType.APPLICATION_JSON))
                .content(SerializeJsonResourceTestSupport.convertObjectToJsonBytes(personMock))).andDo(print())
                .andExpect(status().isBadRequest());

        Mockito.verify(personManager, times(0)).update(Mockito.anyLong(), Mockito.any());
    }

    /**
     * Given person when update then return not found.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenUpdateThenReturnNotFound() throws Exception {

        Person personMock = PersonResourceTestSupport.createPerson();

        Mockito.when(personManager.update(Mockito.anyLong(), Mockito.any())).thenThrow(EntityNotFoundException.class);

        mockMvc.perform((put("/v1//people/{personId}", 0L).contentType(MediaType.APPLICATION_JSON))
                .content(SerializeJsonResourceTestSupport.convertObjectToJsonBytes(personMock))).andDo(print())
                .andExpect(status().isNotFound());

        Mockito.verify(personManager, times(1)).update(Mockito.anyLong(), Mockito.any());
    }

    /**
     * Given person when delete then return is no content.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenDeleteThenReturnIsNoContent() throws Exception {

        mockMvc.perform((delete("/v1/people/{personId}", 1L).contentType(MediaType.APPLICATION_JSON)))
                .andDo(print()).andExpect(status().isNoContent());

        Mockito.verify(personManager, times(1)).delete(Mockito.anyLong());
    }

    /**
     * Given person when delete then return bad request.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenDeleteThenReturnBadRequest() throws Exception {

        mockMvc.perform((delete("/v1/people/{personId}", "abc").contentType(MediaType.APPLICATION_JSON)))
                .andDo(print()).andExpect(status().isBadRequest());

        Mockito.verify(personManager, times(0)).delete(Mockito.anyLong());
    }

    /**
     * Given person when delete then return not found.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenPersonWhenDeleteThenReturnNotFound() throws Exception {

        Mockito.doThrow(EntityNotFoundException.class).when(personManager).delete(Mockito.anyLong());

        mockMvc.perform((delete("/v1/people/{personId}", 1L).contentType(MediaType.APPLICATION_JSON)))
                .andDo(print()).andExpect(status().isNotFound());

        Mockito.verify(personManager, times(1)).delete(Mockito.anyLong());
    }
}
