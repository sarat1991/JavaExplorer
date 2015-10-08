
public class Subset {

	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String>();

		 //In input = new In(new Scanner(System.in));
		//In input = new In(new File("E:\\TestInput\\Subset\\Test123.txt"));
		
		// Out output = new Out("E:\\Output.txt");

		 int k =   StdIn.readInt();
		while (!StdIn.isEmpty()) {
			String inputSt = StdIn.readString();
			
			if (rq.size() == k) {
				rq.dequeue();
				rq.enqueue(inputSt);
			} else
				rq.enqueue(inputSt);

		}

		for (String outSting : rq)
			StdOut.println(outSting);
	}

}
