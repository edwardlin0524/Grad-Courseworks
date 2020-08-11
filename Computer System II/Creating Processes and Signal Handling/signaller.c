#include	<stdlib.h>
#include	<stdio.h>
#include	<string.h>
#include	<signal.h>
#include	<unistd.h>
#include <sys/types.h> //used for getpid() 
//1. It should have global integers:maxSignalTime, shouldContinue with initial value 1
int maxSignalTime=0;
int shouldContinue = 1;
const MIN_TIME_IN_SECS = 2;

//3. main() should install 2 signal handlers
void sigalrm_handler(int sig) {
	printf("signaller %d signalling parent \n", getpid());
	alarm(rand() % maxSignalTime + 1);
	kill(getppid(), SIGUSR1);

}
void sigint_handler(int sig) {
	printf("signaller %d stopping \n", getpid());
	shouldContinue = 0;
	
}

int main(int argc, char * argv[]) {
	struct sigaction	act;
	memset(&act, '\0', sizeof(act));
	act.sa_handler = sigalrm_handler;
	sigaction(SIGALRM, &act, NULL);

	act.sa_handler = sigint_handler;
	sigaction(SIGINT, &act, NULL);
	//2.main() should get 1 extra command line argument, an integer maxSignalTime. It should verify that this argument exists, 
	//and it should verify that it is at least MIN_TIME_IN_SECS.
	if (argv[1] != NULL) {
		maxSignalTime = atoi(argv[1]);
		if (maxSignalTime >= MIN_TIME_IN_SECS) {
			//4.main() should do srand(getpid());which randomizes its random generator.
			srand(getpid());
			//5. main() should do alarm(rand() % maxSignalTime + 1);which sets the initial timer.
			alarm(rand() % maxSignalTime + 1);

			while (shouldContinue)
			{
				sleep(1);
			}
		}
		
	}

	return(EXIT_SUCCESS);
}
