# leader-election-test
To emulate:
docker-compose up
start microservice and multiple instances. Only one will be the leader. 

Multiple instances should start and one of the instances should log that it is a leader. If the leader will be killed then new one should be elected and it should immediately start printing the leader message
