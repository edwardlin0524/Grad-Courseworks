# Applied Algorithm and Structure

This class covered basic concepts of algorithm such as Correctness of algorithms, running time, etc.. The most interesting part for me is **Dynamic Programming**. Dynamic Programming solves the smallest sub-problems first, then using those solutions to solve the next larger sub-problems and so on. People usually **creates a table and fills in each cells in such way** that doing so only requires values from previously filled cells. **One of the cells in this table gives the solution to the original problem.**  

Following are some algorithms using Dynamic Programming approach:
<ol>
 <li>  
  
  **[Longest Common Subsequence](https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCS.java)**  
Implement the bottom-up algorithm for finding the longest common subsequence of two strings. The program takes two strings and returns the length of their LCS. Following is the picture of Longest Common Subsequence table:
<p align="center"><img src="https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCS.jpg" width="300"></p>  

  **How I implemented this algorithm?**  
  <ol>
  <li>Draw a table with two strings on a paper. (See the picture above) </li> 
  <li>Fill 0 for first column and row. </li>
  <li>Fill cells from left to right, up to down. Fill 1 in the cell when encountered same chracters at first time. </li>
  <li>For the rest of cells, follow these rules: 
   <ol>
    <li>If the left value of current cell greater or equal to the top value of current cell, then current cell value equals to the left cell value. </li>
    <li>If the left value and the top value are same, put the number in upper left cell plus 1 into current cell.  </li>
   </ol> 
   </li>
  <li>Return the most lower right cell, that is the value we want. </li>
  </ol>
  </li>
<li>

**[Longest Common Subsequence Version 2](https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCSv2.java)**  
Building on the **[Longest Common Subsequence](https://github.com/edwardlin0524/GradCourseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCS.java)**  Program, find the LCS and print it.  
<p align="center"><img src="https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/LCSv2.jpg" width="300"></p>  

  **How I implemented this algorithm?**  
1. Use the table we drawn previously.
2. Find the upper left arrows (means that two characters are same).
3. Create a array called 'bTable' in the program, which stores directions as strings such as 'N', 'W' and 'NW'.
4. In the program, create a recursion method to match string 'NW' and find the locations of those same characters and print them out.  
</li> 

<li>

**[Minimum Edit Distance](https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/MED.java)**  
Convert string 'depaul' to 'declaw', find the minimum edit distance and return it.  
<p align="center"><img src="https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/MED.jpg" width="50%"></p>  

  **How I implemented this algorithm?**  
<ol>
  <li>Draw a table with two strings on a paper. (See the picture above) </li> 
  <li>Fill cells from left to right, up to down.</li>
  <li>Values of cells are determined by following rules:</li>
   <ol>
    <li>If the two strings are same, current cell would be the value of upper-left cell. </li>
    <li>If the two strings are different, current cell would be the minimum of up, left and upper-left cells.  </li>
   </ol>
  <li>The most lower-right cell is the minimum edit distance.</li>
  </ol>

</li>

<li>  
  
  **[Optimal Rod Cutting](https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/ORC.java)**  
  Given a rod of length n and an array which contains prices of all pieces smaller than n, find the maximum obtainable prices. The main idea is that we make a cut at different positions, then compare the values obtained after a cut and find the maximum price. Take following pictures for example, if the length of rod is 4, we can cut the rod at (1,3),(2,2),(4)(which means no cut), we find the maximum obtainable value in these combinations is 10 (because we cut at position 1 and 4).
<p align="center"><img src="https://github.com/edwardlin0524/Grad-Courseworks/blob/master/Applied%20Algorithm%20and%20Structure/Dynamic%20Programming/ORC.jpg" width="50%"></p>
 </li> 

</li>
