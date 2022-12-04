package br.com.luaazul.controller;

import javax.validation.Valid;

import br.com.luaazul.entity.Comment;
import br.com.luaazul.repository.CommentRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

@Validated
@Controller("/comment")
public class CommentController {
    
    @Inject
    private CommentRepository commentRepository;

    @Post()
    public HttpResponse<?> savePerson(@Body @Valid Comment comment) {
        this.commentRepository.save(comment);
        return HttpResponse.status(HttpStatus.CREATED).body("SUCESSO!");
    }

    @Get()
    public HttpResponse<?> getPersons() {
        return HttpResponse.status(HttpStatus.OK).body(this.commentRepository.findAll());
    }

}
