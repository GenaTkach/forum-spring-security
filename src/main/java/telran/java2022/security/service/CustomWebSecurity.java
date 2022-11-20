package telran.java2022.security.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.accounting.dao.UserAccountRepository;
import telran.java2022.accounting.model.UserAccount;
import telran.java2022.post.dao.PostRepository;
import telran.java2022.post.model.Post;

@Service("customSecurity")
@RequiredArgsConstructor
public class CustomWebSecurity {

    final PostRepository postRepository;
    final UserAccountRepository userRepository;

    // Метод проверки авторства
    public boolean checkPostAuthor(String postId, String userName) {
	Post post = postRepository.findById(postId)
		.orElse(null);
	return post != null && userName.equalsIgnoreCase(post.getAuthor());
    }

    // Метод проверки срока действия пароля
    public boolean checkPasswordLimitation(String login) {
	UserAccount userAccount = userRepository.findById(login)
		.orElse(null);
	long period = ChronoUnit.DAYS.between(userAccount.getPasswordCreationDate(), LocalDate.now());
	return period < 30;
    }

}
