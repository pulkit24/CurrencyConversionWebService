package client.utilities;

public class Log {
	public static boolean DEBUGGING = false;

	private static int errorCount = 1;

	public static void debug(String context, String message) {
		if (Log.DEBUGGING) {
			System.out.println(context + ": " + message);
		}
	}

	public static void debug(String context, double[] message) {
		if (Log.DEBUGGING) {
			System.out.print(context + ": ");
			for (int i = 0; i < message.length; i++) {
				System.out.print(message[i]);
				if (i < message.length - 1)
					System.out.print(", ");
			}
			System.out.println("");
		}
	}

	public static void debug(String context, Object[] message) {
		if (Log.DEBUGGING) {
			System.out.print(context + ": ");
			for (int i = 0; i < message.length; i++) {
				System.out.print(message[i]);
				if (i < message.length - 1)
					System.out.print(", ");
			}
			System.out.println("");
		}
	}

	public static void notify(String noticeMessage) {
		System.out.println("Notice: " + noticeMessage);
	}

	public static void notifyInProgress(String noticeMessage) {
		System.out.print("Notice: " + noticeMessage + "... ");
	}

	public static void notifyProgressComplete() {
		System.out.println("Completed.");
	}

	public static void error(String friendlyMessage, Exception e) {
		System.out.println("Error " + errorCount + ": " + friendlyMessage);
		if (Log.DEBUGGING)
			System.err.println("Full stack trace:\n" + e.toString());
		Log.errorCount++;
	}
}
