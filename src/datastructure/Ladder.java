package datastructure;
public class Ladder implements Set 
{

	private Rep[] reps;
	private int type, difficulty, rest, totalDistance;
	
	public Ladder(int type) 
	{
		if (Math.random() < 0.5)
		{
			//TODO step up
		}
		else
		{
			//TODO step down
		}
	}
	
	//build off reading in
	public Ladder(int type, String[] stringReps, int rest)
	{
		this.rest = rest;
		this.type = type;
		reps = new Rep[stringReps.length];
		for (int i = 0; i < stringReps.length; i++)
		{
			Rep rep = decode(stringReps[i]);
			reps[i] = rep;
			totalDistance += rep.getDistance();
		}
		difficulty = calculateDifficulty();
	}

	@Override
	public int getDifficulty() 
	{
		return difficulty;
	}

	@Override
	public Rep[] getReps() 
	{
		return reps;
	}

	@Override
	public int getType() 
	{
		return type;
	}

	@Override
	public int getRest() 
	{
		return rest;
	}
	
	private int calculateDifficulty()
	{
		int total = 0;
		for (Rep rep: reps)
		{
			total += rep.getDifficulty();
		}
		int restdiff = rest * 30;
		return total - restdiff;
	}
	
	private Rep decode(String rep)
	{
		String[] nums = rep.split(";");
		return new Rep(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]), Integer.parseInt(nums[3]));
		
	}
	@Override
	public int getDistance() 
	{
		return totalDistance;
	}
	@Override
	public String tostring()
	{
		String workout = "";
		for (Rep rep : reps)
		{
			workout += rep;
		}
		return String.format("%s\n Rest: %d seconds\n", workout, rest);
	}

	@Override
	public String pack() 
	{
		String temp = "";
		for (Rep run : reps)
			temp += run.toString() + "-";
		
		return String.format("%d\n%s\n%d", type, temp.substring(0, temp.length() - 2), rest);
	}
	
	


}
