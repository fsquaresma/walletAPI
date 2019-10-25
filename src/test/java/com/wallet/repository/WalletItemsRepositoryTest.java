package com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;
import com.wallet.util.enums.TypeEnum;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class WalletItemsRepositoryTest {
	
	private static final Date DATE = new Date();
	private static final TypeEnum TYPE = TypeEnum.EN;
	private static final String DESCRIPTION = "Conta de luz";
	private static final BigDecimal VALUE = BigDecimal.valueOf(65);
	
	@Autowired
	WalletItemRepository walletItemRepository;
	
	@Autowired
	WalletRepository walletRepository;

	@BeforeEach
	public void setUp() {
		
	}
	
	@AfterEach
	public void tearDown() {
		
	}
	
	@Test
	public void testSave() {
		Wallet wallet = new Wallet();
		
		wallet.setName("Carteira 1");
		wallet.setValue(BigDecimal.valueOf(500));
		
		walletRepository.save(wallet);
		
		WalletItem walletItem = new WalletItem(wallet, DATE, TYPE, DESCRIPTION, VALUE);
		
		WalletItem response = walletItemRepository.save(walletItem);
		
		assertNotNull(response);
		assertEquals(response.getDescription(), DESCRIPTION);
	}
	
}
