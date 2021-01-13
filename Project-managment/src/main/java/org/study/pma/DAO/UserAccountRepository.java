package org.study.pma.DAO;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.study.pma.Entities.UserAccount;


public interface UserAccountRepository  extends PagingAndSortingRepository<UserAccount, Long>{

}
