// The problem is a well-known Josephus problem, which has a direct mathematical formula to find the winner.

/*
Recursive Formula:
The position of the winner f(n,k)f(n,k) for nn friends and step kk can be calculated as:
   -Base case: f(1,k)=0f(1,k)=0 (0-based indexing)
   -Recursive relation: f(n,k)=(f(n−1,k)+k)%n

To convert to 1-based indexing:
   -Final result: f(n,k)+1
*/


public int findTheWinner(int n, int k) {
    int winner = 0; // Base case for 1 person (0-based index)
    for (int i = 2; i <= n; i++) {
        winner = (winner + k) % i; // Update winner for i people
    }
    return winner + 1; // Convert to 1-based index
}

// Use this approach when the problem resembles the Josephus problem, and you’re asked to determine the winner in a circular elimination game.