package hello.board;

import hello.board.config.WebConfig;
import hello.board.config.post.PostConfig;
import hello.board.config.user.UserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Slf4j
@Import({UserConfig.class, PostConfig.class, WebConfig.class})
@SpringBootApplication(scanBasePackages = "hello.board.controller")
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
