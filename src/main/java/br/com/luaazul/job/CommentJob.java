package br.com.luaazul.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.luaazul.entity.Comment;
import br.com.luaazul.repository.CommentRepository;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class CommentJob {
    
    @Inject
    private CommentRepository commentRepository;

    @Scheduled(fixedDelay = "10s") 
    void executeEveryTen() {
        log.info("Simple Job every 10 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

    @Scheduled(cron = "* * * * *")
    public void addNewComment(){
        Comment comment = new Comment();
        
        comment.setContent("New comment with Job!!");
        this.commentRepository.save(comment);

        log.info("New comment add with success!");
    }

}
