public class PracticeProblem {
	public static void main(String args[]) {

	}

	public static int[] recaman(int n) {
		if(n <= 0) {
			return new int[0];
		}
		int arr[] = new int[n];
		recamanHelper(n, arr);
		return arr;
	}

	public static void recamanHelper(int n, int[] arr) {
		if (n == 1) {
			arr[0] = 1;
			return;
		}

		recamanHelper(n - 1, arr);
		int termRes = arr[n - 2] - n;
		if (termRes < 0) {
			termRes = arr[n - 2] + n;
		} else {
			for (int i = 0; i < n; i++) {
				if (arr[i] == termRes) {
					termRes = arr[n - 2] + n;
					i = n;
				}
			}
		}
		arr[n - 1] = termRes;  // n - 1 is the index for the current term (e.g., n = 4, so n - 1 = 3)
		//term is the value we calculated (in this case 2) bc arr[3] = 2
		//n is the current position 
		// we need to subtract 1 from n to get the actual index/value of the current term in the array
	}
}

/*
 * recamanHelper(1, arr) → arr = [1]

recamanHelper(2, arr) → arr = [1, 3] (1 - 2 = -1 invalid, so 1 + 2 = 3)

recamanHelper(3, arr) → arr = [1, 3, 6] (3 - 3 = 0, invalid, so 3 + 3 = 6)

recamanHelper(4, arr) → arr = [1, 3, 6, 2] (6 - 4 = 2, valid)

recamanHelper(5, arr) → arr = [1, 3, 6, 2, 7] (2 - 5 = -3 invalid, so 2 + 5 = 7)

recamanHelper(6, arr) → arr = [1, 3, 6, 2, 7, 13] (7 - 6 = 1 already in array, so 7 + 6 = 13)


 */