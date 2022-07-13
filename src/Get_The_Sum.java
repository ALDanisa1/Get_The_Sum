import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Get_The_Sum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        String empty = input.nextLine();
        System.out.println("Are you going tyo use the file or numbers");
        System.out.println("Enter n for numbers or f for file");
        String question = input.nextLine();
        ArrayList<Integer> nums = new ArrayList<>();

        if(question.equalsIgnoreCase("f")){
            System.out.println("Enter the name of a file");
            String filename = input.nextLine();
            File file = new File("src/" +filename);
            Scanner line_Scanner = new Scanner(file);

            while(line_Scanner.hasNext()){
                nums.add(Integer.parseInt(line_Scanner.nextLine()));
            }

        }
       else if (question.equalsIgnoreCase("n")) {
            System.out.println("Enter the numbers and press q to cancel");
            String numbers = input.nextLine();
            nums.add(Integer.parseInt(numbers));

            while(!(numbers.equalsIgnoreCase("q") )){
                numbers = input.nextLine();
                if(!(numbers.equalsIgnoreCase("q") )){
                    nums.add(Integer.parseInt(numbers));
                }
            }
        }
        System.out.println(Solution(nums,target));
    }
    public static String Solution(ArrayList<Integer> nums,int target){
        for(int i = 0;i< nums.size(); i++){
            for (int j = 0; j < nums.size(); j++) {
                int answer = sum(nums.get(i),nums.get(j));
                if(check_target(target,answer)){
                    System.out.println("The numbers that can meet the target are " +nums.get(i)+" and "+nums.get(j)+".");
                    return  "They can be found in position " + i + " and " + j +".";
                }
                else if(!check_target(target, answer) && i == nums.size()-1 && j == nums.size()-1){
                    return "Sorry Target Not met try using different values.";
                }
            }
        }
        return null;
    }
    public static boolean check_target(int target,int number){
        boolean target_met = false;
        if(target == number ){
            target_met = true;
            return target_met;
        }
        else {
            return target_met;
        }}
    public static int sum(int a, int b){
        int answer = 0;
        answer = a+b;
        return answer;
    }
}
