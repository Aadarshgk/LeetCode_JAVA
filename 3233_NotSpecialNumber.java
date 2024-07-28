import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int nonSpecialCount(int l, int r) {
        int n= (int) Math.sqrt(r);
        List<Integer> primes= isPrime(n);
        int count=0;
        for(Integer a: primes){
            if(a*a <=r && a*a >=l){
                count++;
            }
        }

        return r-l+1-count;
    }

    public List<Integer> isPrime(int n){
        boolean[] ar= new boolean[n+1];
        Arrays.fill(ar,true);
        ar[0]=ar[1]=false;
        for(int i=2;i<=n;i++){
            if(ar[i]){
                for(int j=i*i;j<=n;j+=i){
                    ar[j]=false;
                }
            }
        }

        List<Integer> primes= new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(ar[i]){
                primes.add(i);
                System.out.println(i);
            }
        }
        return primes;
    }
}