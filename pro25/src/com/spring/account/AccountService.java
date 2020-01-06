package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional을 이용해 AccountService클래스의 모든 메서드에 트랜잭션을 적용합니다.
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDAO accDAO;

	// 속성 accDAO에 빈을 주입하기 위해 setter를 구현합니다.
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}

	// sendMoney()메서드 호출 시 accDAO의 두 개의 SQL문을 실행합니다.
	public void sendMoney() throws Exception {
		accDAO.updateBalance1();
		accDAO.updateBalance2();
	}
}


