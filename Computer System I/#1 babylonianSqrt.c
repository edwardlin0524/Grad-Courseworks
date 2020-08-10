#include <stdio.h>	
#include <stdlib.h>	

const int TEXT_LEN = 64;

void obtainFloat (float* fPt)
{
	char text[TEXT_LEN];
	do{
	printf("Please enter a floating point number(0 - 65535): ");
	fgets(text,TEXT_LEN,stdin);
	*fPt = atof(text);
	}
	while(*fPt<0||*fPt>65535);
}

float squareRoot(float number, int maxIters, int* numItersPtr)
{
	
	float	estimate = 1.0;
	do{
	estimate = 0.5*(estimate+number/estimate);
	*numItersPtr += 1;
	}while((estimate*estimate!=number)||maxIters!=100);
	return(estimate);
}				 				 		
int main()
{ 				
	float f;
	float ans;
	int numIters=0;
	obtainFloat(&f);
	ans	= squareRoot(f,100,&numIters);
	printf("squareRoot(%g) approx. equals %g (found in %d iterations).\n",
			f,ans,numIters
	      );
	return(EXIT_SUCCESS);
}
