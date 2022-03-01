branch = "master"
git_url = "https://github.com/sspatil05/sachin.git"

freeStyleJob('create-update-ec2-stack-devl') {
    logRotator(numToKeep = 100)
    parameters {

        
	choiceParam("ENVIRONMENT", ["Qa13","qa14","perf"])
        choiceParam("OPERATIONS", ["dry_run","deploy","delete"])
        choiceParam("RE_CREATE", ["false","true"])
    }
    scm {
	    git {
            remote {
                  url(git_url)
                 
            }
            branch(branch)
        }
    }
    steps {
        shell( '''#!/opt/rh/rh-python36/root/usr/bin/python
import boto3
ec2 = boto3.resource('ec2')
# create a new EC2 instance
instances = ec2.create_instances(
     ImageId='ami-0915bcb5fa77e4892',
     MinCount=1,
     MaxCount=1,
     InstanceType='t2.micro',
	
     KeyName='test-aws-key'
 )
        ''')
    }
}
