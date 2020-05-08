public class CustomerTest {
	public static void main(String[] args) {
		String x="", y="", z="";
		Customer item1 = new Customer();
		Customer item2 = new Customer("Jacob",10,1001,500000D);
		Customer item3 = new Customer();
		item3.inputCustomerDetail();
		item1.calculateAverage();
		item2.calculateAverage();
		item3.calculateAverage();
		double a = Math.max(item1.average, item2.average);
		double b = Math.max(item2.average, item3.average);
		double c = Math.max(a, b);
		if (c==item1.average)
			x = "High";
		else if (c==item2.average)
			y = "High";
		else if (c==item3.average)
			z = "High";
		double aa = Math.min(item1.average, item2.average);
		double bb = Math.min(item2.average, item3.average);
		double cc = Math.min(aa, bb);
		if (cc==item1.average)
			x = "Low";
		else if (cc==item2.average)
			y = "Low";
		else if (cc==item3.average)
			z = "Low";
		String format = "%10s |%10s |%15s |%10s |%15s |";
		System.out.printf(format, "Number", "Name", "Total", "Count", "Average");
		System.out.println();
		item1.print(x);
		item2.print(y);
		item3.print(z);
			
		
	}

}
