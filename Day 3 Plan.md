Recursion occurs when the definition of a **concept** or **process** depends on a simpler or previous version of itself. Recursion is used in a variety of disciplines ranging from linguistics to logic. The most common application of recursion is in mathematics and computer science, where a function being defined is applied within its own definition. While this apparently defines an infinite number of instances (function values), it is often done in such a way that no infinite loop or infinite chain of references can occur.



Implementation issues

In actual implementation, rather than a pure recursive function (single check for base case, otherwise recursive step), a number of modifications may be made, for purposes of clarity or efficiency. These include:



Wrapper function (at top)

Short-circuiting the base case, aka "Arm's-length recursion" (at bottom)

Hybrid algorithm (at bottom) – switching to a different algorithm once data is small enough

On the basis of elegance, wrapper functions are generally approved, while short-circuiting the base case is frowned upon, particularly in academia. Hybrid algorithms are often used for efficiency, to reduce the overhead of recursion in small cases, and arm's-length recursion is a special case of this.



Wrapper function

A wrapper function is a function that is directly called but does not recurse itself, instead calling a separate auxiliary function which actually does the recursion.



Wrapper functions can be used to validate parameters (so the recursive function can skip these), perform initialization (allocate memory, initialize variables), particularly for auxiliary variables such as "level of recursion" or partial computations for memoization, and handle exceptions and errors. In languages that support nested functions, the auxiliary function can be nested inside the wrapper function and use a shared scope. In the absence of nested functions, auxiliary functions are instead a separate function, if possible private (as they are not called directly), and information is shared with the wrapper function by using pass-by-reference.



Short-circuiting the base case



Factorial: ordinary vs. short-circuit 

Ordinary recursion	Short-circuit recursion

int fac1(int n) {

&nbsp;   if (n <= 0) {

&nbsp;       return 1;

&nbsp;   } else {

&nbsp;       return fac1(n - 1) \* n;

&nbsp;   }

}

int fac2(int n) {

&nbsp;   // assert(n >= 2);

&nbsp;   if (n == 2) {

&nbsp;       return 2;

&nbsp;   } else {

&nbsp;       return fac2(n - 1) \* n;

&nbsp;   }

}

int fac2wrapper(int n) {

&nbsp;   if (n <= 1) {

&nbsp;       return 1;

&nbsp;   } else {

&nbsp;       return fac2(n);

&nbsp;   }

}

Short-circuiting the base case, also known as arm's-length recursion, consists of checking the base case before making a recursive call – i.e., checking if the next call will be the base case, instead of calling and then checking for the base case. Short-circuiting is particularly done for efficiency reasons, to avoid the overhead of a function call that immediately returns. Note that since the base case has already been checked for (immediately before the recursive step), it does not need to be checked for separately, but one does need to use a wrapper function for the case when the overall recursion starts with the base case itself. For example, in the factorial function, properly the base case is 0! = 1, while immediately returning 1 for 1! is a short circuit, and may miss 0; this can be mitigated by a wrapper function. The box shows C code to shortcut factorial cases 0 and 1.



Short-circuiting is primarily a concern when many base cases are encountered, such as Null pointers in a tree, which can be linear in the number of function calls, hence significant savings for O(n) algorithms; this is illustrated below for a depth-first search. Short-circuiting on a tree corresponds to considering a leaf (non-empty node with no children) as the base case, rather than considering an empty node as the base case. If there is only a single base case, such as in computing the factorial, short-circuiting provides only O(1) savings.



Conceptually, short-circuiting can be considered to either have the same base case and recursive step, checking the base case only before the recursion, or it can be considered to have a different base case (one step removed from standard base case) and a more complex recursive step, namely "check valid then recurse", as in considering leaf nodes rather than Null nodes as base cases in a tree. Because short-circuiting has a more complicated flow, compared with the clear separation of base case and recursive step in standard recursion, it is often considered poor style, particularly in academia.





print 1 to n

print n to 1

number of digits

sum of digits

Fibonacci

factorial

fact(n) = n \* fact(n-1)

multiply two numbers

mul( 8, 4)

&nbsp;  8 + mul(8,3)

&nbsp;       8+mul(8,2)

&nbsp;            8+mul(8,1)

&nbsp;                  



reverse a number 2:17 2.40



gcd

lcm

6974=>4796

4\*1000 + 7 \* 100 + 9 \* 10 + 6 \* 1

6974

6\*1

974



6974

0

4\*1+0

4\*10+7

47\*10+9

479\*10+6

4796



gcd

gcd(a,b) = gcd(b,a%b)

gcd(100,22) = gcd(22,12)

lcm // 3:30 3:35



Backtracking

~~~~~~~~~~~~

Backtracking is an algorithmic technique for solving problems incrementally by trying options one by one and abandoning (backtracking from) any candidate that fails to satisfy constraints. It is a refined brute-force approach, frequently used for puzzles (Sudoku, N-Queens), pathfinding, and combinatorial problems, often implemented using recursion.













0				1

000000000000000000000000

0000000000000000000000000000000000000000000

nod=0;

n=0;

while ( n != 0)

{

&nbsp;  nod++;

&nbsp;  n/=10;

}



&nbsp;		N

&nbsp;	P1		P2

&nbsp;		697437

&nbsp;	69		7437



&nbsp;	P1 = N / 10000; N / 10^(nod in p2)

&nbsp;	P2 = N % 10000; N % 10^(nod in p2)



&nbsp;		p1			p2

&nbsp;			n



&nbsp;		n = p1 \* 10^(nod in p2 ) + p2







34500068

45000683

50006834

00068345

00683450

06834500

68345000

83450006

34500068



















