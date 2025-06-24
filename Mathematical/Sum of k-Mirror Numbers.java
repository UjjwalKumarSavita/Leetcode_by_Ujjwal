class  Solution{
    public long kMirror(int k, int n){
        long sum = 0;
        int len = 1; // 1,2,3,4,5,6,7,8,9

        while(n > 0){
            int halflenOfNum = (len + 1) / 2;


            long minNum = (long)Math.pow(10, halflenOfNum - 1);
            long maxNum = (long)Math.pow(10, halflenOfNum) - 1;

            for(long i = minNum ; i <= maxNum ; i++){
                String firstHalf = Long.toString(i);
                String secondHalf = new StringBuilder(firstHalf).reverse().toString();
                
                String number ;
                if(len % 2 == 0){
                    number = firstHalf + secondHalf.substring(1);
                } else {
                    number = firstHalf + secondHalf;
                }

                long num = Long.parseLong(number);
                String baseKNum = changeToKBase(num, k);
                //each number ka binary find karna hai

                if(isPalindrom(baseKNum)){
                    sum += num;
                    n--;
                    if(n == 0) return  sum;
                }
            
            }
            len++;

        }
        return sum;
    }

    //easy methods........ but help full
    public boolean isPalindrom(String num){
        int st = 0, end = num.length()-1;
        while(st < end){
            if(num.charAt(st) != num.charAt(end)) return false;
            st++;
            end--;
        }

        return true;
    }
    public String changeToKBase(long num, int k){
        if (num == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            res.append(num % k);
            num /= k;
        }
        return res.toString();
    }
}