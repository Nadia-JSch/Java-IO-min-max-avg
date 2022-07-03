# Java-IO-min-max-avg
The aim of this project is to demonstrate retrieving data stored in a text file, performing an operation on that data and writting the results to another text file. 

## Description

Data is read from input.txt where an operation (minimum, maximum, average, percentile) is followed by numbers with which to perform the operation on. Each operation has a respective method. Each line of data is read from the file, parsed into an integer array and its result written to output.txt.

## Example excerpt
### Input

P90: 1,2,3,4,5,6,7,8,9,10

### Output

The 90th percentile of [1,2,3,4,5,6,7,8,9,10] is 9.

## Dependencies

* java.io* (for FileReader and FileWriter objects)
* java.util.Arrays (for toString method)
* input.txt
* output.txt
