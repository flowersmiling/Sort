# Introduce
This program allows users to sort a list of 3D geometrical shapes by their height, volume, and base area with six different algorithms, such as bubble sort, insertion sort, selection sort, merge sort, quick sort, and shell sort by descending order  (from largest to smallest).

# Design Methodology
 1. Abstraction-oriented programing: This way of referring to higher-level types as much as possible and avoiding references to actual subtypes is called abstraction-oriented programming.
 2. Strategy pattern: Abstract a class to represent a three-dimensional geometrical shape.
 3. Reflection mothod: Generates the objects using reflection of class.

# Data Files
 1. Shapes: Cylinder, Cone, Prism, Pyramid
 2. Cylinders and cones are followed by a double value representing the height and another double value representing radius.
   e.g. Cylinder 9431.453 4450.123 or Cone 674.2435 652.1534
 3. Pyramids are followed by a double value representing the height and another double value representing edge length.
   e.g. Pyramid 6247.53 2923.456
 4. Prisms are specified by the type of base polygon (SquarePrism, TrianglarPrism, PentagonalPrism, OctagonalPrism), a double value representing the height and another double value representing edge length.
   e.g. SquarePrism 8945.234 3745.334
 
# Run the program
File name F, the compare type and the sort type are provided as parameters (-f –t –s or -F –T –S) via command line. The program must be order and case insensitive. For example, all examples below are valid inputs:
 
  java -jar sort.jar -fpolyfor1.txt -Tv -Sb
 
  java -jar sort.jar -ta -sQ -f"res\polyfor3".txt
 
  java -jar sort.jar -tH -F"C:\temp\polyfor5.txt" –sB
 
Where v is volume, h is height, a is base area, b is bubble, s is selection, i is insertion, m is merge, q is quick, and your choice of sorting algorithm is z.
