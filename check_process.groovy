branch = "master"
git_url = "https://github.com/sspatil05/sachin.git"


freeStyleJob("check-processes-ec2-devl") {
    description 'Checks java pids running on the instance'
    logRotator(daysToKeep = -1, numToKeep = 10, artifactDaysToKeep = -1, artifactNumToKeep = -1)
    label('devl-slave')
    parameters {
      		  stringParam("NODE_GROUP","app-EC2", 'Node_group of the instances' )
      		  stringParam('INSTANCEID', ' ', 'Copy App Instance ID From AWS Console, Paste Here. Only provide one instance id' )

    }

    wrappers {
      preBuildCleanup()
      maskPasswords()
    }
    steps {
        shell('''#!/bin/bash
    set -e
    }
    sendCommand $NODE_GROUP $INSTANCEID
    echo 'Job completed.'
		''')
   }
}
