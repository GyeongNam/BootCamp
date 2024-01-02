public class BaseProblem {
    public static void main(String[] args) {
        int n = 125;
        int answer = 0;
        String temp = "";
        while (n!=0){
            temp += Integer.toString(n%3);
            n/=3;
        }
        System.out.println(temp);

        int temp_length = temp.length()-1;
        for (int i = 0; i < temp.length(); i++) {
            answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * (int)Math.pow(3,temp_length);
            temp_length--;
        }
        System.out.println(answer);

        //  return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
    }
}
