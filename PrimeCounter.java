import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class PrimeCounter {
    
    public static int time = 5;
    public static int size = 100000;

    public static void main(String[] args){
        
        DecimalFormat timerFormat  = new DecimalFormat("0.000000#");
        
        long start = System.nanoTime();        
        
        //System.out.println("Number of primes between 1 to 1000: " + primeCount(size));
        // System.out.println("Number of primes found: " + timerCount(time));
        //System.out.println("Number of primes found between 1 to " + size + " is: " + smarterPrimeCount(size));
        //sieve_of_eratosthenes(size);
        //System.out.println("Number of primes found between 1 to " + size + " is: " + primeSieve(size));
        

        long end = System.nanoTime();
        long timeTaken = end - start;

        System.out.print("Time Taken: " + timerFormat.format(timeTaken/(Math.pow(10, 9))));
    }
    
    public static int primeCount(int n){
        int count = 0,  index = 2;
        boolean isPrime = true;

        while(index <= n){

            for(int i =2; i<index; i++){
                if(index % i == 0 && isPrime)
                    isPrime = false;
            }

            if(isPrime)
                count++;
            index++;
            isPrime = true;
        }

        return count;
    }

    public static int timerCount(int sec){
        int count = 0,  index = 2;
        boolean isPrime = true;
        
        PrintWriter toFile = null;
        try{
            File prime = new File("Primes.txt");
            toFile = new PrintWriter(prime);
        }
        catch(IOException e){

        }

        LocalTime start = LocalTime.now();
        LocalTime end = start.plusSeconds(sec+1);
        
        while(Duration.between(start, end).getSeconds() > 0){
            //System.out.println(Duration.between(start, end).getSeconds());
            for(int i =2; i<index; i++){
                if(index % i == 0 && isPrime)
                    isPrime = false;
            }

            if(isPrime){
                count++;
                toFile.print(index + " ");
            }

            index++;
            
            isPrime = true;
            start = LocalTime.now();
        }

        return count;
    }

    public static int smarterPrimeCount(int n){
        int index = 7, digit = 7, count = 3;
        boolean isPrime = true;
        while(index < n){
            
            for(int i =2; i < index/2; i++){
                if(index % i == 0 && isPrime)
                    isPrime = false;
            }

            if(isPrime){
                count++;
            }

            switch(digit){
                case 1: index+=2; digit = 3; break;
                case 3: index+=4; digit = 7; break;
                case 7: index+=2; digit = 9; break;
                case 9: index+=2; digit = 1; break;
                default: isPrime = false;
            }

            isPrime = true;
        }
        
        return count;
    }

    public static void sieve_of_eratosthenes(int n)
    {
        boolean[] is_prime = new boolean[n + 1];
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (is_prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    is_prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (is_prime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static int primeSieve(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        for(int p =2; p*p<n; p++){
            if(prime[p]){
                for(int i = p*2; i<=n; i+= p){
                    prime[i] = false;
                }
            }
        }
        int count = 0;
        for(int i =2; i<= n; i++){
            if(prime[i])
                count++;
        }
        return count;
    }


}

// Look into an algorithm that adds specifically 
// into odd numbers and not even consider even numbers
// and maybe look into doing an byte array that contains the digits
// that we can manipulate to quick read in and figure out if the number is prime
