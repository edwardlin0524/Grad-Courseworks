/*--------------------------------------------------------------------------*
 *----									----*
 *----		headers.h						----*
 *----									----*
 *----	    This file declares common headers used through-out the	----*
 *----	the singly-linked list sorting program.				----*
 *----									----*
 *----	----	----	----	----	----	----	----	----	----*
 *----									----*
 *----	Version 1a		2019 April 8		Joseph Phillips	----*
 *----									----*
 *--------------------------------------------------------------------------*/

#include	<stdlib.h>
#include	<stdio.h>
#include	"Node.h"
extern struct Node*	insertionSort(struct Node*	nodePtr);
extern struct Node* mergeSort(struct Node*	nodePtr);
extern struct Node* mergeSortWrapper(struct Node*	nodePtr);
 //  YOUR CODE HERE
