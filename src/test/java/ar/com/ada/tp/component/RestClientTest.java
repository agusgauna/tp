package ar.com.ada.tp.component;

import ar.com.ada.tp.model.rest.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestClientTest {

    @Test
    public void whenCallEndpointTodosThenReturnTodoResponse() {
        //GIVEN
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        RestClient<Todo> client = new RestClient();

        //WHEN
        Todo todoResponse =client.getOne(url, new ParameterizedTypeReference<Todo>(){});

        //THEN
        assertEquals("delectus aut autem", todoResponse.getTitle());
        assertThat(todoResponse.getTitle()).isEqualTo("delectus aut autem");

    }
    @Test
    public void whenCallAllEndpointTodosThenReturnTodoListResponse() {
        // GIVEN
        String url = "https://jsonplaceholder.typicode.com/todos";
        RestClient<Todo> client = new RestClient();

        // WHEN
        List<Todo> todoList = client.getList(url, new ParameterizedTypeReference<List<Todo>>(){});

        // THEN
        assertEquals(200, todoList.size());
        assertThat(todoList.size()).isEqualTo(200);
    }

    @Test
    public void whenPostndpointTodosThenReturnTodoResponseCreate() {
        // GIVEN
        String url = "https://jsonplaceholder.typicode.com/todos";
        RestClient<Todo> client = new RestClient();
        Todo todoToSave = new Todo()
                .setTitle("My Todo")
                .setUserId(1)
                .setCompleted(Boolean.FALSE);

        // WHEN
        ResponseEntity<Todo> responseEntity = client.post(url, todoToSave, new ParameterizedTypeReference<Todo>(){});

        // THEN
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}