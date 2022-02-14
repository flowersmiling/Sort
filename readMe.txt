***********************************************************
* Project title: SORTING OUT SORTING (CPRG311 Assignment 1) *
* Authors: Chaoling Lu, Sheng Ming Yan, MengdanLiu       *
* Date: 2022 Feburary 11st                                                  *
***********************************************************

What the program does:
This program allows users to sort a list of shapes by their height, volume, and base area with six different algorithms, 
such as bubble sort, insertion sort, selection sort, merge sort, quick sort, and shell sort. 
The compare type is descending order  (from largest to smallest).

 * Display a user selection menu
 * To scan/load shapes txt file
 * To add data into an array
 * To return a polyArray by using reflection with different shape and its height and radius
 * To sort the polyArray with user selected method (shapes are comparable and compare with the comparator)
 * Output the sorted result with the largest,lowest, and the thousandth value


To run the program:
1. Press the Win key + X hotkey and select Command Prompt (Admin) to open it as administrator.
2. Input the following command (replacing the example with the actual path of the file you need to run) and press Enter:
	java -jar sort.jar -tH -Fc:\polyfor1.txt -sB
3.valid sort types on command line for example: 
	java -jar sort.jar -tH -Fc:\polyfor1.txt -sB
where v is volume, h is height, a is base area, b is bubble, s is selection, i is insertion, m is merge, q is quick sort, and z is shell sort.

IMPORTANT NOTE: if any running error happened, make sure the Encoding of polyfor*.txt file is saved as either ANSI or UTF-8 !! 