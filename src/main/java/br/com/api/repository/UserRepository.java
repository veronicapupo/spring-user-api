package br.com.api.repository;

import br.com.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // usamos o crud para termos acesso as operacoes no banco,
// setamos qual é a classe  anotada com o @Entity e falamos que o id dela é inteiro
public interface UserRepository extends JpaRepository<User, Integer> {

}
