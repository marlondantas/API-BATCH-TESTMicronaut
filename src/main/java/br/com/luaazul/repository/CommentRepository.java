package br.com.luaazul.repository;

import br.com.luaazul.entity.Comment;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
    
}
