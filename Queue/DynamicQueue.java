package Queue;

public class DynamicQueue extends QueueUsingArrays {

	@Override
	public void enqueue(int item) throws Exception {
		// TODO Auto-generated method stub
		
		if(this.size == data.length) {
			int[] newData = new int[2 * data.length];
			
			for(int i = 0; i < data.length; i++) {
				int idx = i + front;
				idx = idx % data.length;
				newData[i] = data[idx];
			}
			
			data = newData;
			front = 0;
		}
		
		super.enqueue(item);
	}
	
	
}
