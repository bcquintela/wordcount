#  Word Count

A Java application for text analysis.

Given a text file, the application analyzes the text and outputs a list of its words in alphabetical order, with an indication of the number of
occurrences of each word and the respective lines in which it occurs. It also outputs the number of occurrences of each of the alphabetic characters and the
relative frequency of each character.

For word count, the application uses a binary tree as data structure. The lines where each word occurs are maintained through a linked list.

The number of occurrences of the characters found in the text and the respective
relative frequencies are stored in a priority queue, implemented with a max heap.
