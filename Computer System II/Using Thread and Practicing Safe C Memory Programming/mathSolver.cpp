/*-------------------------------------------------------------------------*
 *---									---*
 *---		mathSolver.cpp						---*
 *---									---*
 *---	    This file defines the high-level functions of the math 	---*
 *---	generator and solver program.					---*
 *---									---*
 *---	----	----	----	----	----	----	----	----	---*
 *---									---*
 *---	Version 1a		2019 May 6		Joseph Phillips	---*
 *---									---*
 *-------------------------------------------------------------------------*/

//
//	Compile with:
//	$ g++ mathSolver.cpp -o mathSolver -lpthread -g
//


#include	"mathSolverHeader.h"


void*		evaluate	(void*		vPtr
				)
{
  NodeBuffer*	nodeBufferPtr	= (NodeBuffer*)vPtr;
   //  YOUR CODE HERE
  int i;
  Node*mynodeptr;
  for (i = 0; i < NUM_PROBLEMS / 2;i++) {
	   mynodeptr = nodeBufferPtr ->pullOut();//
	  printf("%d  %s = %f \n", i, mynodeptr->toString().c_str(), mynodeptr->eval());
	  delete(mynodeptr);
  }
  return(NULL);
  }


//  PURPOSE:  To return a randomly generated Node.
Node*		makeNode	()
{
  return( (rand() % 3) ? (Node*)new ConstNode() : (Node*)new OperatorNode() );
}


int		main		(int		argc,
				 char*		argv[]
				)
{
  NodeBuffer	nodeBuffer;
  pthread_t	consumer0;
  pthread_t	consumer1;
  int		toReturn	= EXIT_SUCCESS;

  srand( (argc < 2) ? getpid() : atoi(argv[1]) );

  //  YOUR CODE HERE
  pthread_create(&consumer0, NULL, evaluate, &nodeBuffer);
  pthread_create(&consumer1, NULL, evaluate, &nodeBuffer);
	  int i;
  for (i = 0; i < NUM_PROBLEMS;i++) {
	  nodeBuffer.putIn(makeNode());
	  printf("Made %d \n", i);
  }
  pthread_join(consumer0, NULL);
  pthread_join(consumer1, NULL);
	  return(toReturn);
}
