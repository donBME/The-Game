

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class ShotHandler {

	private DataAccessPoint data;
	
	public ShotHandler(DataAccessPoint data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		System.out.println("<<ShotHandler::Create(DataAccessPoint data)");
	}

	public DataAccessPoint getdata(){
		return data;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdata(DataAccessPoint newVal){
		data = newVal;
	}

	/**
	 * 
	 * @param shootfrom: lövés iránya
	 * @param color: szín
	 */
	public void Shoot(CVector shootfrom, StarGateColor color){

	}

}