package export001_02;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import export001_02.AmericaTire;
import export001_02.Car;
import export001_02.KoreaTire;
import export001_02.Tire;

public class CarTest {
	
	@Test
	public void 자동차_코리아타이어장착_타이어브랜드_테스트2() {
		
		Tire tire1 = new KoreaTire();
		Car car1 = new Car(tire1);
		
		assertEquals("장착된 타이어 : 코리아타이어", car1.getTireBrand());
		
	}
	@Test
	public void 자동차_미국타이어장착_타이어브랜드_테스트2() {
		
		Tire tire2 = new AmericaTire();
		Car car2 = new Car(tire2);
		
		assertEquals("장착된 타이어 : 미국 타이어", car2.getTireBrand());
		
	}

}
