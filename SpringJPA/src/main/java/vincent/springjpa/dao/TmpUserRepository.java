package vincent.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vincent.springjpa.pojo.TmpUser;

public interface TmpUserRepository extends JpaRepository<TmpUser, Long> {
}
