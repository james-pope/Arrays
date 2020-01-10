/***
Consider a grading scheme where your final grade is computed more generously
if your grades show improvement over the term.  Scores show improvement
if each grade is greater than or equal to the previous grade.

A student has x scores indexed from 0 to x-1.  If the scores have shown improvement
only those grades with indexes greater than to equal to x/2 are averaged.  If the
scores have not improved, all of the scores are averaged.
***/

public class GradeAverage {

	private int [] scores;
	
	public GradeAverage(int [] s)
	{
		scores = s;
	}
	// returns the mean (average) of the values in the scores array
	// whose indexes are between first and last (including first and last).  
	//You may assume that first and last are > 0 and < scores.length
	public double mean(int first, int last)
	{
		//TODO add code here
		//make this public to test this
		double sum = 0;
		int count = 0;
		for (int i = first; i <= last; i++) {
			sum += scores[i];
			count++;
		}
		if (count > 0){
			return sum/(double)count;
		}
		return 0.0;
	}
	
	// returns true if each successive value in scores is greater than
	// or equal to the previous value.  Otherwise returns false
	private boolean showsImprovement()
	{
		//TODO add code here
		int max = scores[scores.length - 1];
		int first;
		int second;
		for (int i = 0; i < scores.length-1; i++){
			first = scores[i];
			second = scores[i+1];
			if (first > second){
				return false;
			}
			if (second > max){
				return false;
			}
		}
		return true;
	}
	
	// if the values in the scores array show improvement, returns the
	// average of the elements in scores with indexes greater than or
	// equal to scores.length()/2
	public double finalGrade()
	{
		//TODO add code here
		if (showsImprovement()){
			return mean(scores.length/2, scores.length-1);
		} else {
			return mean(0, scores.length -1);
		}
	}
	public static void main(String[] args) {
		int [] s1 = {50,50,20,80,53};   // not improved, finalGrade is 50.6
		int [] s2 = {20,50,50,53,80};   // improved, final grade is 61.0
		int [] s3 = {20,50,50,80};      // improved, final grade is 65.0
		
		GradeAverage sr1 = new GradeAverage(s1);
		System.out.println("mean of sr1: " + sr1.mean(1, 4));
		System.out.println("sr1 improves: " + sr1.showsImprovement());
		System.out.println("sr1 final grade: " + sr1.finalGrade());
		GradeAverage sr2 = new GradeAverage(s2);
		System.out.println("mean of sr2: " + sr2.mean(2, 4));
		System.out.println("sr2 improves: " + sr2.showsImprovement());
		System.out.println("sr2 final grade: " + sr2.finalGrade());
		GradeAverage sr3 = new GradeAverage(s3);
		System.out.println("mean of sr3: " + sr3.mean(1, 3));
		System.out.println("sr3 improves: " + sr3.showsImprovement());
		System.out.println("sr3 final grade " + sr3.finalGrade());
	}
/* OUTPUT
mean of sr1: 50.75
sr1 improves: false
sr1 final grade: 50.6
mean of sr2: 61.0
sr2 improves: true
sr2 final grade: 61.0
mean of sr3: 60.0
sr3 improves: true
sr3 final grade 65.0
 */
}
