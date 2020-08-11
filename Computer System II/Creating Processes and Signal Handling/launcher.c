#include	<stdlib.h>
#include	<stdio.h>
#include	<string.h>
#include	<signal.h>
#include	<unistd.h>

//1. global integers
int counter = 0;
int shouldContinue = 1;
int resetTimeInSec;
int signalTimeInSec;

//2. verify that their valuesare at least 2 secs
const MIN_TIME_IN_SECS = 2;

//3. signal handlers 
	//(tasks we want to do when sent signal to Alarm)
void SIGALRM_handler(int sig) {
	counter = 0;
	alarm(resetTimeInSec);
	printf("Resetting \n");
}
	//(tasks we want to do when sent signal to Alarm)
void SIGUSR1_handler(int sig) {
	counter +=1;
	
	if (counter >= 3) 
	{
		printf("got %d  Have reached the limit! \n", counter);
		shouldContinue = 0;
	
	}
	else {
		printf("got %d \n", counter); }
	
}

int main(int argc, char * argv[]) {//receive the strings user typed
	int i;//for loop using
	const int BUFFER_LEN = 64;
	char  buffer[BUFFER_LEN];
	const int N = 3;//child process number
	pid_t pid[N];

	struct sigaction act;
	memset(&act, '\0', sizeof(act));

	act.sa_handler = SIGALRM_handler;
	sigaction(SIGALRM, &act, NULL);//when I receive SIGALRM, please do the SIGALRM_handler, so we need alarm() code below so that we can 
																//execute this handler

	act.sa_handler = SIGUSR1_handler;
	sigaction(SIGUSR1, &act, NULL);//when I receive SIGUSR1, please do the SIGUSR1_handler, sending signal come from signaller 
																//so we need to do kill(which actually send signal to) in signaller.c
	
	if (argc != 3) 
	{
		printf("Usage: launcher <resetTime> <signalTime> \n");
		return(EXIT_FAILURE);
	}
	if (argv[1] != NULL && argv[2] != NULL) {
		resetTimeInSec = atoi(argv[1]);
		signalTimeInSec = atoi(argv[2]);
	 if (resetTimeInSec < MIN_TIME_IN_SECS) {
		printf("resetTime must be 2 or greater. \n");
		return(EXIT_FAILURE);
	}
	else if (signalTimeInSec < MIN_TIME_IN_SECS) {
		printf("signalTime must be 2 or greater. \n");
		return(EXIT_FAILURE);
	}
	}
	//check if they are ligal
	if (resetTimeInSec >= MIN_TIME_IN_SECS &&
		signalTimeInSec >= MIN_TIME_IN_SECS)
	{
		//snprintf: Just convert int(signalTimeInSec) to string and save it into buffer, so now buffer is String type
		snprintf(buffer, BUFFER_LEN, "%d", signalTimeInSec);

		//4. main() should make 3 child processes that then run "signaller"
		for (i = 0; i < N;i++) {
				if ((pid[i]=fork()) == 0) 
				{
					//execl(program name,program to run, argument, null)
					execl("signaller", "signaller", buffer, NULL);
					fprintf(stderr, "Cannot run %s\n", buffer);
					exit(EXIT_FAILURE);
				}
			}
	}

	//5. main() should do alarm(resetTimeInSec);
	//by calling this function, we can do SIGALRM_handler
	alarm(resetTimeInSec);

	//6.main() should do while shouldContinue is true, do sleep for 1 sec 
	while (shouldContinue)
	{
		sleep(1);
	}

	//7. When the game is over it send SIGINT to all children. 
	//It also wait()s for them to finish
	for (i = 0; i < 3; i++) {
		kill(pid[i], SIGINT);
		wait(NULL);
	}

	//8.main() should return(EXIT_SUCCESS);
	return(EXIT_SUCCESS);
}





