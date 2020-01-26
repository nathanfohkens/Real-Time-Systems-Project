import java.io.File;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Event> events = Event.fromCSV(new File("floorEvents.csv"));
		for (Event event: events) {
			System.out.println(event);
		}
	}
}
