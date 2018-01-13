package kata.game;

public class Game {

	private int[] rolls = new int[21]; // 存取投球數的陣列
	private int currentRoll = 0; // 投球數指標

	// 投球
	public void roll(int bottle) { // 瓶數
		rolls[currentRoll++] = bottle;
	}

	// 計分
	public int scores() {
		int score = 0;
		int frameIndex = 0; // 投球術指標
		for (int frame = 0; frame < 10; frame++) {
			if(isStrike(frameIndex)){
				score+=10+strikeBonus(frameIndex);
				frameIndex++;
			}
			else if (isSpare(frameIndex)) {
				score += 10 + rolls[frameIndex + 2];
				frameIndex += 2;

			} else {
				score += rolls[frameIndex] + rolls[frameIndex + 1];
				frameIndex += 2;
			}
		}
		return score;
	}

	// 判斷是否為補中 (Spare)
	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
	}

	//判斷是否為全倒 (Strike)
	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

	private int sumOfBallsInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

}
