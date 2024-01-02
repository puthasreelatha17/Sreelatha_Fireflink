package arrays;

public class PrimeNumbersInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,6,5,9,11,4};

        System.out.println("Prime numbers in the array:");
        for (int num : arr) {
            boolean isPrime = true;
            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
    }
}
