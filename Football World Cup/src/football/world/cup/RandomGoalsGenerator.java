


package football.world.cup;


public class RandomGoalsGenerator {
    /*
    The team with the highest ranking will have a greater chance of winning. 
    This will be simulated by giving the higher ranked team a wider range of
    possible goals as follows:

	Higher ranked team: a goal range of 0 to (5 + a random upset (a random
    number between 0 and 2))
	Lower ranked team: a goal range of 0 to ((5 – difference in team rank)
    + a random
upset (a random number between 0 and 2))

    */
    public static int numberOfGoals(int diff)
    {
        int upper = 5 - diff + (int)(Math.random()*2);
        
        int goals = (int)(Math.random() * upper);
        
        return goals;
        
    }

}
