package ExceptionHandlingg;

public class DynamicStack extends Stack {

	
	@Override
	public void push(int value) throws Exception {
		// TODO Auto-generated method stub
		
		if(isFull()) {
			//resizing - inc capacity - double 
			
			int[] newData = new int[data.length * 2];//5*2 = 10
			
			for(int i = 0; i < data.length; i++) {
				newData[i] = data[i];///data se newData mein copy
			}

			data = newData;
		}
		
		super.push(value);
	}
	
	public static void main(String[] args) throws Exception {
		
		DynamicStack ds = new DynamicStack();
		for(int i = 1; i < 1000; i++) {
			ds.push(i);
		}
		
		ds.display();
	}
}
