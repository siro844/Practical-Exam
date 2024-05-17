import java.util.Arrays;
import java.util.Comparator;

class Item {
	int weight;
	int value;

	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

class Main {
	public static double getMaxValue(int[] weights, int[] values, int capacity) {
		Item[] items = new Item[weights.length];

		for (int i = 0; i < weights.length; i++) {
			items[i] = new Item(weights[i], values[i]);
		}

		Arrays.sort(items, Comparator.comparingDouble
		((Item i) -> (double) i.value / i.weight).reversed());

		double totalValue = 0;
		int remainingCapacity = capacity;

		for (Item item : items) {
			if (remainingCapacity >= item.weight) {
				totalValue += item.value;
				remainingCapacity -= item.weight;
			} else {
				totalValue += (double) item.value / item.weight * remainingCapacity;
				break;
			}
		}

		return totalValue;
	}

	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 50;

		double maxValue = getMaxValue(weights, values, capacity);
		System.out.println("Maximum value that can be obtained = " + maxValue);
	}
}