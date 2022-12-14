package telran.java2022.accounting.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserAccountResponseDto {
	String login;
	String firstName;
	String lastName;
	@Singular
	Set<String> roles;
	LocalDate passwordCreationDate;
}
