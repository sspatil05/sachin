branch = "master"
git_url = "https://github.com/sspatil05/sachin.git"


freeStyleJob("start-stop-app-devl") {
    description 'Deploys app to a given account'
    logRotator(daysToKeep = -1, numToKeep = 10, artifactDaysToKeep = -1, artifactNumToKeep = -1)
    

	scm {
        git {
            remote {
                url("${git_url}")
                
            }
            branch("${branch}")
            extensions {
            }
        }

    }
    parameters {
            choiceParam("OPERATION", ["start","stop","restart"])
      		  choiceParam("NODE_GROUP",["  ","app-EC2","coll-EC2","app-EC2&coll-EC2"] )
      		  stringParam('INSTANCEID', ' ', 'Copy Instance ID From AWS Console' )

    }

    wrappers {
      preBuildCleanup()
      maskPasswords()
    }
    steps {
        shell('''#!/bin/bash
    set -e





		''')
   }
}
