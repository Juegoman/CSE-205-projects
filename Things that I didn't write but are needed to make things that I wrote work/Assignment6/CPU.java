// Assignment #: 6
//         Name: 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: The CPU class descrives a CPU including type and speed.
// 		         It also provides their accessor, mutator methods,
//	             and toString method.


public class CPU {
	private String type;
	private int speed;

	/************************************************************************
	Constructor method to initialize intance variables.
	************************************************************************/
	public CPU() {
		type = "?";
		speed = 0;
	}

	/************************************************************************
	Accessor method:
	This method returns the type of the CPU.
	************************************************************************/
	public String getType() {
		return type;
	}

	/************************************************************************
	Accessor method:
	This method returns the speed of the CPU.
	************************************************************************/
	public int getSpeed() {
		return speed;
	}

	/************************************************************************
	Modifier method:
	This method sets the type variable of the CPU.
	************************************************************************/
	public void setType(String type2) {
		type = type2;
	}

	/************************************************************************
	Modifier method:
	This method sets the speed variable of the CPU.
	************************************************************************/
	public void setSpeed(int speed2) {
		speed = speed2;
	}

        /************************************************************************
        This method return a string containing the attribute information in CPU
	************************************************************************/
        @Override
        public String toString() {
            return (type + "," + speed + "HZ");
        }

}//end of CPU class.
