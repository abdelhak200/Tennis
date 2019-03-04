package it.yook.tennis;

public class Points {

	public static String getScore(int pt) {
		switch (pt) {
		case 0:
			return "Love";
		case 1:

			return "Fifteen";
		case 2:

			return "Thirty";
		case 3:

			return "Fourty";

		default:
			return "null";
		}
	}

}
