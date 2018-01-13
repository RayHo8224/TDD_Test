package kata.game.test;

import static org.junit.Assert.*;

import kata.game.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	// 測試玩家投球共20次全洗溝 (gutter)時的總得分數
	// 期望結果值：0
	@Test
	public void testGutterGame() {
		int expected = 0;
		int actual;

		rollMany(20, 0);
		actual = game.scores();

		assertEquals(expected, actual);
	}

	// 測試玩家投球共20次，每次都只得一分時的總得分數
	// 期望結果值：20
	@Test
	public void testAllOne() {
		int expected = 20;
		int actual;

		rollMany(20, 1);
		actual = game.scores();

		assertEquals(expected, actual);

	}

	// 測試玩家整局只有一次補中+次一計分格投球的分數
	// 共 20 次投球機會，其餘 17 次皆0分
	@Test
	public void testOneSpare() {
		int expected = 26;
		int actual;

		rollSpare();
		game.roll(8);
		game.roll(0);
		rollMany(16, 0);
		actual = game.scores();

		assertEquals(expected, actual);

	}

	// 測試玩家整局只有一次全中+次一計分格兩次投球的分數
	// 共 19 次投球機會，其餘 16 次皆0分
	@Test
	public void testOneStrike() throws Exception {
		
		int expected = 24;
		int actual;
		
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16,0);
		actual=game.scores();
		
		assertEquals(expected, actual);
		
	}
	
	
	// 測試玩家在所有全倒的12次投球的總得分數 (滿分300分)
	@Test
	public void testPerfectGame() throws Exception {
		int expected = 300;
		int actual;
		
		rollMany(12,10);
		actual = game.scores();
		
		assertEquals(expected, actual);
	}	

	private void rollMany(int roll, int bottle) {
		for (int i = 0; i < roll; i++) {
			game.roll(bottle);
		}

	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	private void rollStrike(){
		game.roll(10);
	}

}
