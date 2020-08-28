# Applied Algorithm and Structure

From this class, I learn some basic concepts such as Correctness of algorithms, running time, etc. and different type of algorithms such as:

1. **[Longest Common Subsequence](https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCS.java)**  
Implement the bottom-up algorithm for finding the longest common subsequence of two strings. The program takes two strings and returns the length of their LCS. Following is the picture of Longest Common Subsequence table:
<p align="center"><img src="https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCS.jpg" width="300"></p>  

**How I implemented this algorithm?**  
1. Draw a table with two strings on a paper. (See the picture above)  
2. Fill 0 for first column and row.  
3. Fill cells from left to right, up to down. Fill 1 in the cell when encountered same chracters at first time.
3. For the rest of cells, follow these rules:  
-If the left value of current cell greater or equal to the top value of current cell, then current cell value equals to the left cell value.  
-If the left value and the top value are same, put the number in upper left cell plus 1 into current cell.  
4. Return the most lower right cell, that is the value we want.
