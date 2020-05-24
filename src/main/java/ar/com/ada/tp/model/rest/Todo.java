package ar.com.ada.tp.model.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private Boolean completed;

    public Todo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Todo setTitle(String title) {
        this.title = title;
        return this;
    }

    public Todo setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }
}
