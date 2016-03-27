

/**
 * @author Laszlo
 * @version 1.0
 * @created 20-márc.-2016 12:28:33
 */
public class SpecialWall extends Wall {
	
	public SpecialWall(){
        System.out.println(">>SpecialWall::SpecialWall()");
		System.out.println("<<SpecialWall::SpecialWall()");
	}
	
    @Override
    public boolean Shootable() {
        System.out.println(">>SpecialWall::Shootable()");
        System.out.println("<<SpecialWall::Shootable()");
        return true;
    }
}